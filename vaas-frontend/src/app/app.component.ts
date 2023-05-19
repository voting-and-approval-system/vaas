import { Component } from '@angular/core';
import { LoginService } from './_services/login.service';
import { UsersService } from './_services/users.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'vaas-frontend';

  constructor(    
    public userService: UsersService,
    public loginService : LoginService
  ) {}

  ngOnInit(): void {
    this.loginService.loadGoogleApi();
  }
}
