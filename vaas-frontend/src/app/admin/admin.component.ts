import { Component } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  constructor(public userAuthService : UserAuthService,public router : Router){}

  public logout() {
    console.log("After Clear :" +localStorage.getItem('preferedRole'));
    this.userAuthService.clear();
    console.log("After Clear :" +localStorage.getItem('preferedRole'));
    this.router.navigate(['/home']);
  }

}
