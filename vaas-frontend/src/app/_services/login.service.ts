import { Injectable, OnInit } from '@angular/core';
import { UsersService } from './users.service';
import { UserAuthService } from './user-auth.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { RegisterComponent } from '../register/register.component';
import { formatDate } from '@angular/common';

declare const gapi: any;

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  userEmail!: string;
  public tempRole: string;
  userFirstName: string | null = null;
  userPhotoUrl: string | null = null;


  constructor(
    private userService: UsersService,
    private userAuthService: UserAuthService,
    private router: Router,
    private register: MatDialog
  ) { }

  ngOnInit(): void {
    // Retrieve user's name and image from sessionStorage on component initialization
    this.userFirstName = sessionStorage.getItem('userFirstName');
    this.userPhotoUrl = sessionStorage.getItem('userPhotoUrl');
  }
  

  openForm(newUser: any, userEmail: string) {
    const dialogRef = this.register.open(RegisterComponent);
    dialogRef.componentInstance.formSubmitted.subscribe(({ houseNumber, phoneNumber }) => {
      if (houseNumber == null || phoneNumber == null) {
        return;
      }
      newUser.houseNumber = houseNumber || '';
      newUser.phoneNumber = phoneNumber || '';
      this.userService.register(newUser).subscribe(
        (response: any) => {
          this.loginWithGoogle(userEmail);
        },
        (error: any) => {
        }
      );
    });
  }

  signInWithGoogle(): void {
    gapi.load('auth2', () => {
      gapi.auth2.init({
        client_id: '374191778060-j6pbqqlneq1hv5c8lijgmj6ihhkf12gi.apps.googleusercontent.com',
        scope: 'profile',
        plugin_name: 'vaas-frontend',
        prompt: 'select_account'
      }).then(() => {
        Promise.resolve(gapi.auth2.getAuthInstance().signIn())
          .then((googleUser: any) => {
            const userEmail = googleUser.getBasicProfile().getEmail();
            this.loginWithGoogle(userEmail);
          })
          .catch((error: any) => {
            if (error.details === 'popup_closed_by_user') {
              console.log('User closed the Google sign-in popup');
            } else {
              console.log('Error occurred during Google sign-in', error);
            }
          });
      }).catch((error: any) => {
        console.log("Error");
      });
    });
  }

  loginWithGoogle(userEmail: string): void {
    localStorage.setItem('userEmail', userEmail);

    const googleUser = gapi.auth2.getAuthInstance().currentUser.get();
    const profile = googleUser.getBasicProfile();

    const firstName = profile.getGivenName();
    const lastName = profile.getFamilyName();

    const newUser = {
      firstName: firstName,
      lastName: lastName,
      phoneNumber: '',
      userEmail: userEmail,
      houseNumber: '',
      userJoiningDate: formatDate(new Date(), 'yyyy-MM-dd', 'en-US'),
      userUpdatedDate: formatDate(new Date(), 'yyyy-MM-dd', 'en-US'),
      userIsActive: true
    };

    this.userService.login({ userEmail }).subscribe(
      (response: any) => {
        this.userAuthService.setRoles(response.roles);
        this.userAuthService.setToken(response.jwtToken);

        const role = response.roles;
        if (role.includes('Admin') && role.includes('Tenant')) {
          this.router.navigate(['/adminoption']);
        }
        else if (role.includes('Admin')) {
          this.tempRole = "Admin";
          this.userAuthService.setPreferdRole('Admin');
          this.router.navigate(['/admin']);
        }
        else if (role.includes('Tenant')) {
          this.userAuthService.setPreferdRole('Tenant');
          this.tempRole = "Tenant";
          this.router.navigate(['/user']);
        }
        else {
          this.router.navigate(['/pending']);
        }
        const firstName = profile.getGivenName();
        const photoUrl = profile.getImageUrl();

        localStorage.setItem('userFirstName', firstName);
        localStorage.setItem('userPhotoUrl', photoUrl);


      },
      (error) => {
        if (error.status === 500) {
          this.openForm(newUser, userEmail);
        } else {
          console.log('Error occurred during login', error);
        }
      }

    );
  }

  private logoutAndNotifyGoogle(): void {
    localStorage.removeItem('userEmail');
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('userFirstName');
    localStorage.removeItem('userPhotoUrl');
    const auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(() => {
      console.log('User signed out from Google');
    });
  }

  checkTokenExpiration(): void {
    const jwtToken = localStorage.getItem('jwtToken');
    const tokenExpiration = localStorage.getItem('tokenExpiration');

    if (jwtToken && tokenExpiration) {
      const expirationTime = new Date(tokenExpiration).getTime();
      const currentTime = new Date().getTime();

      if (currentTime >= expirationTime) {
        this.logoutAndNotifyGoogle();
        this.router.navigate(['/home']);
      }
    }
  }

}
