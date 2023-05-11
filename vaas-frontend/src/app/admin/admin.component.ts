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
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }

}
