import { Component } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { UsersService } from '../_services/users.service';
import { LoginService } from '../_services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(public uas : UserAuthService,public us : UsersService,public ls : LoginService){

  }

  public isLoggedIn() {
    return this.uas.isLoggedIn();
  }

}
