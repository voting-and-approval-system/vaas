import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/_services/login.service';
import { UserAuthService } from 'src/app/_services/user-auth.service';
import { UserServicesService } from '../user-services.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userData; 
  userEmail: string = localStorage.getItem('userEmail');
  userPhotoUrl: string;

  constructor(
    private _userService: UserServicesService,
    private userAuthService: UserAuthService,
    private router: Router,
    private loginService: LoginService,
  ) {}



  async ngOnInit(): Promise<void> {
    try {
      const res: any = await this._userService.findUserByEmail(localStorage.getItem('userEmail')).toPromise();
      this.userData = res;
      console.log(this.userData)
    } catch (error) {
      console.error(error);
    }

    this.userPhotoUrl = localStorage.getItem('userPhotoUrl');
  }


}
