import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { LoginService } from '../_services/login.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(public userAuthService : UserAuthService,public router : Router,private loginService : LoginService){}
  ngOnInit(): void {
    if(!this.userAuthService.isLoggedIn()){
      this.router.navigate(['/home']);
    }
  }

  public logout() {
    console.log("After Clear :" +localStorage.getItem('preferedRole'));
    this.userAuthService.clear();
    console.log("After Clear :" +localStorage.getItem('preferedRole'));
    this.router.navigate(['/home']);
  }

}
