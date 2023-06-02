import { Component, EventEmitter, HostListener, OnInit, Output } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { LoginService } from '../_services/login.service';




interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

interface ngOnInit {
  screenWidth: number;
  collapsed: boolean;
}

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  userFirstName: string | null = null;
  userPhotoUrl: string | null = null;
  constructor(private userAuthService: UserAuthService, private router: Router, private loginService: LoginService) {
  }

  public logout() {
    console.log("After Clear :" + localStorage.getItem('preferedRole'));
    this.userAuthService.clear();
    console.log("After Clear :" + localStorage.getItem('preferedRole'));
    this.router.navigate(['/home']);
  }

  @Output() onToggleSideNav: EventEmitter<SideNavToggle> = new EventEmitter();
  collapsed = true;
  screenWidth = 0;


  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.screenWidth = window.innerWidth;
    if (this.screenWidth <= 768) {
      this.collapsed = false;
      this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
    }
  }

  ngOnInit(): void {
    if (!this.userAuthService.isLoggedIn()) {
      this.router.navigate(['/home']);
    }
    this.screenWidth = window.innerWidth;
    this.userFirstName = localStorage.getItem('userFirstName');
    this.userPhotoUrl = localStorage.getItem('userPhotoUrl');
  }

  toggleCollapse(): void {
    this.collapsed = !this.collapsed;
    this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
  }

  closeSidenav(): void {
    this.collapsed = false;
    this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
  }
}




  
