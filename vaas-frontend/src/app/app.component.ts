import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './_services/login.service';
import { UserAuthService } from './_services/user-auth.service';
import { UsersService } from './_services/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'vaas-frontend';

  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    public userService: UsersService,
    public loginService : LoginService
  ) {}

  ngOnInit(): void {
    this.loginService.loadGoogleApi();
  }
}
