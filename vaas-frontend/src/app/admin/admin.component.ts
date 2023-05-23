// <<<<<<< Updated upstream
// <<<<<<< Updated upstream
// <<<<<<< Updated upstream
// import { Component, OnInit } from '@angular/core';
// =======
// =======
// >>>>>>> Stashed changes
// =======
// >>>>>>> Stashed changes
// import { Component } from '@angular/core';
// import { UserAuthService } from '../_services/user-auth.service';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-admin',
//   templateUrl: './admin.component.html',
//   styleUrls: ['./admin.component.css']
// })
// export class AdminComponent {

//   constructor(public userAuthService : UserAuthService,public router : Router){}

//   public logout() {
//     this.userAuthService.clear();
//     this.router.navigate(['/home']);
//   }

// }

import { Component, EventEmitter, HostListener, Input, OnInit, Output } from '@angular/core';
import { navbarData } from './nav-data';
import { animate, animation, keyframes, style, transition, trigger } from '@angular/animations';
// <<<<<<< Updated upstream
// <<<<<<< Updated upstream
// >>>>>>> Stashed changes
// =======
// >>>>>>> Stashed changes
// =======
// >>>>>>> Stashed changes
import { UserAuthService } from '../_services/user-auth.service';
import { Router } from '@angular/router';
import { LoginService } from '../_services/login.service';

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({

  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  animations: [
    trigger('fadeInOut', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('350ms',
          style({ opacity: 1 })
        )
      ]),
      transition(':leave', [
        style({ opacity: 1 }),
        animate('350ms',
          style({ opacity: 0 })
        )
      ])
    ])
  ]
})
export class AdminComponent implements OnInit {

// <<<<<<< Updated upstream
// <<<<<<< Updated upstream
// <<<<<<< Updated upstream

  constructor(public userAuthService : UserAuthService,public router : Router,private loginService : LoginService){}
  ngOnInit(): void {
    if(!this.userAuthService.isLoggedIn()){
      this.router.navigate(['/home']);
      this.screenWidth = window.innerWidth;
    }
  }
// =======
//   constructor(public userAuthService: UserAuthService, public router: Router) { }
// >>>>>>> Stashed changes
// =======
//   constructor(public userAuthService: UserAuthService, public router: Router) { }
// >>>>>>> Stashed changes
// =======
//   constructor(public userAuthService: UserAuthService, public router: Router) { }
// >>>>>>> Stashed changes

  public logout() {
    console.log("After Clear :" +localStorage.getItem('preferedRole'));
    this.userAuthService.clear();
    console.log("After Clear :" +localStorage.getItem('preferedRole'));
    this.router.navigate(['/home']);
  }

  @Output() onToggleSideNav: EventEmitter<SideNavToggle> = new EventEmitter();
  collapsed = true;
  screenWidth = 0;
  navData = navbarData;

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.screenWidth = window.innerWidth;
    if (this.screenWidth <= 768) {
      this.collapsed = false;
      this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
    }
  }

  toggleCollapse(): void {
    this.collapsed = !this.collapsed;
    this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
  }

  closeSidenav(): void {
    this.collapsed = false;
    this.onToggleSideNav.emit({ collapsed: this.collapsed, screenWidth: this.screenWidth });
  }

  // @Input() collapsed = false;
  // @Input() screenWidth = 0;

  getBodyClass(): string{
    let styleClass = '';
    if(this.collapsed && this.screenWidth > 768){
      styleClass = 'body-trimmed';
    }else if(this.collapsed && this.screenWidth <= 768 && this.screenWidth > 0){
      styleClass = 'body-md-screen'
    }
    return styleClass;
  }
}

