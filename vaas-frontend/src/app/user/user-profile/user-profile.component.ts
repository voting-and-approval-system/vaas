import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/_services/login.service';
import { UserAuthService } from 'src/app/_services/user-auth.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  data: any;
  userEmail: string | null = null;
  _userService: any;


  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    private loginService: LoginService,
  ) {}

  ngOnInit(): void {
    this.userEmail = this.loginService.userEmail;
    if (this.userEmail) {
      this.findUserByEmail();
    }
  }

  findUserByEmail(): void {
    this._userService.findUserByEmail(this.userEmail).subscribe(
      (res: any) => {
        this.data = res;
      },
      (error: any) => {
        console.error(error);
      }
    );
  }
}
