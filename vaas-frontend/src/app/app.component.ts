import { Component } from '@angular/core';
import { LoginService } from './_services/login.service';
import { UsersService } from './_services/users.service';

interface SideNavToggle{
  screenWidth: number;
  collapsed: boolean;
}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'vaas-frontend';

  isSideNavCollapsed = false;
  screenWidth = 0;

  onToggleSideNav(data: SideNavToggle): void{
    this.screenWidth = data.screenWidth;
    this.isSideNavCollapsed = data.collapsed;
  }

  constructor(    
    public userService: UsersService,
    public loginService : LoginService
  ) {}

  ngOnInit(): void {
    // this.loginService.loadGoogleApi();
    // this.loginService.signInWithGoogle();
  }
}
