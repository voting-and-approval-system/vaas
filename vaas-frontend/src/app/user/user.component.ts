import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { LoginService } from '../_services/login.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{

  constructor(private userAuthService : UserAuthService,private router: Router,private loginService : LoginService){
  }

  ngOnInit(): void {
    if(!this.userAuthService.isLoggedIn()){
      this.router.navigate(['/home']);
    }
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }
}
