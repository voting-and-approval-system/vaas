import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../_services/user-auth.service';
import { UsersService } from '../_services/users.service';

declare const gapi: any; // Declare gapi object

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  userEmail!: string; // Variable to store the user's email

  constructor(
    private userService: UsersService,
    private userAuthService: UserAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadGoogleApi();
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

    // Perform any additional login actions if needed
    this.userService.login({ userEmail }).subscribe(
      (response: any) => {
        this.userAuthService.setRoles(response.roles);
        this.userAuthService.setToken(response.jwtToken);

        const role = response.roles[0];
        if (role === 'Admin') {
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/user']);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
