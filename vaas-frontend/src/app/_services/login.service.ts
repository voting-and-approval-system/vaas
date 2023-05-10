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
  userEmail!: string; // Variable to store the user's email
  public tempRole : string;

  constructor(
    private userService: UsersService,
    private userAuthService: UserAuthService,
    private router: Router,
    private register : MatDialog
  ) {}

  openForm(newUser : any,userEmail : string) {
    const dialogRef = this.register.open(RegisterComponent);
    dialogRef.componentInstance.formSubmitted.subscribe(({ houseNumber, phoneNumber }) => {
      console.log("Data On Login Page : " + houseNumber + " " + phoneNumber);
      // If the error is 500 (user not found), prompt for house number and phone number
          
          if(houseNumber == null || phoneNumber == null){
            return;
          }
          
          newUser.houseNumber = houseNumber || '';
          newUser.phoneNumber = phoneNumber || '';
  
          // Register the user with the entered details
          this.userService.register(newUser).subscribe(
            (response: any) => {
              // Registration successful, perform login actions
              console.log('User registered successfully:', response);
  
              // You can perform the login actions here or call the loginWithGoogle method again
              this.loginWithGoogle(userEmail);
            },
            (error: any) => {
              console.log('Error occurred during user registration', error);
            }
          );
    });
  }
  

  loadGoogleApi(): void {
    gapi.load('auth2', () => {
      gapi.auth2.init({
        client_id: '374191778060-j6pbqqlneq1hv5c8lijgmj6ihhkf12gi.apps.googleusercontent.com', // Replace with your actual client ID
        scope: 'email', 
        plugin_name: 'vaas-frontend'// Add the scope for retrieving the user's email
      }).then((error:any)=>{
        console.log("Success");
        console.log(error);
      }).catch((error:any)=>{
        console.log("Error");
        console.log(error);
      });
    });
   
  }
  

  signInWithGoogle(): void {
    gapi.auth2.getAuthInstance().signIn().then((googleUser: any) => {
      console.log(googleUser);
      this.userEmail = googleUser.getBasicProfile().getEmail(); // Fetch the user's email and assign it to the userEmail variable
      this.loginWithGoogle(this.userEmail);
       // Pass the userEmail to the loginWithGoogle method
    })
    .catch((error: any) => {
      if (error.details === 'popup_closed_by_user') {
        console.log('User closed the Google sign-in popup');
      } else {
        console.log('Error occurred during Google sign-in', error);
      }
    });
  }

  loginWithGoogle(userEmail: string): void {
    console.log('User email:', userEmail);

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
    console.log(firstName);

    // Perform any additional login actions if needed
    this.userService.login({ userEmail }).subscribe(
      (response: any) => {
        this.userAuthService.setRoles(response.roles);
        console.log(response.roles);
        this.userAuthService.setToken(response.jwtToken);

        const role = response.roles;
        if (role.includes('Admin') && role.includes('Tenant')) {
          this.router.navigate(['/adminoption']);
        } 
        else if(role.includes('Admin'))
        {
          this.tempRole = "Admin";
          this.router.navigate(['/admin']);
        }
        else {
          this.tempRole = "Tenant";
          this.router.navigate(['/user']);
        }
      },
      (error) => {
        if (error.status === 500) {
          this.openForm(newUser,userEmail);
        } else {
          console.log('Error occurred during login', error);
        }
      }
      
    );
  }
}
