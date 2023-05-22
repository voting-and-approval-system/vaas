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

<<<<<<< Updated upstream
<<<<<<< Updated upstream
  constructor(public uas: UserAuthService, public us: UsersService, public ls: LoginService,private router : Router) {
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

  constructor(public uas : UserAuthService,public us : UsersService,public ls : LoginService,public userAuthService: UserAuthService, public router: Router){

  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);
<<<<<<< Updated upstream
  }
  ngOnInit(): void {
    console.log(this.isLoggedIn());
    if (this.isLoggedIn()) {
      const preferedRole = localStorage.getItem('preferedRole');
      if(preferedRole == 'Admin'){
        this.router.navigate(['/admin']);
        console.log(preferedRole);
      }else{
        this.router.navigate(['/user']);
        console.log(preferedRole);
      }
    }
=======
>>>>>>> Stashed changes
  }

  public isLoggedIn() {
    return this.uas.isLoggedIn();
  }

}
