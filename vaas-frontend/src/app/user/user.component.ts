import { Component, OnInit} from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { LoginService } from '../_services/login.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  userFirstName: string | null = null;
  userPhotoUrl: string | null = null;
  userEmail: string | null = null;
  constructor(private userAuthService: UserAuthService, private router: Router, private loginService: LoginService) {
  }

  public logout() {
    this.userAuthService.clear();
    this.router.navigate(['/home']);
  }

  ngOnInit(): void {
    if (!this.userAuthService.isLoggedIn()) {
      this.router.navigate(['/home']);
    }
    this.userFirstName = localStorage.getItem('userFirstName');
    this.userPhotoUrl = localStorage.getItem('userPhotoUrl');
    this.userEmail = localStorage.getItem('userEmail');
  }

  userProfile(userEmail: string) {
    this.router.navigate(['/user/profile', { userEmail: userEmail }]);
  }
}




  
