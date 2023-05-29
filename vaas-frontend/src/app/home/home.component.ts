import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { UsersService } from '../_services/users.service';
import { LoginService } from '../_services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public uas: UserAuthService, public us: UsersService, public ls: LoginService, public userAuthService: UserAuthService, public router: Router) {

  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }
  ngOnInit(): void {
    if (this.isLoggedIn()) {
      const preferedRole = localStorage.getItem('preferedRole');
      if (preferedRole == 'Admin') {
        this.router.navigate(['/admin']);
      } else {
        this.router.navigate(['/user']);
      }
    }

  }

  public isLoggedIn() {
    return this.uas.isLoggedIn();
  }

}
