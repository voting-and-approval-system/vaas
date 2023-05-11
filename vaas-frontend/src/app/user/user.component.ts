import { Component } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  constructor(private userAuthService : UserAuthService,private router: Router,){

  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }
}
