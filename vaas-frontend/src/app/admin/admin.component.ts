import { Component, EventEmitter, HostListener, OnInit, Output } from '@angular/core';
import { navbarData } from './nav-data';
import { animate, animation, keyframes, style, transition, trigger } from '@angular/animations';

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
    ]),
    trigger('rotate',[
      transition(':enter',[
        animate('1000ms',
        keyframes([
          style({transform: 'rotate(0deg)',offset: '0'}),
          style({transform: 'rotate(2turn)',offset: '1'})
        ]))
      ])
    ])
  ]
})
export class AdminComponent implements OnInit {


  constructor(public userAuthService : UserAuthService,public router : Router,private loginService : LoginService){}


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

  ngOnInit(): void {
    if(!this.userAuthService.isLoggedIn()){
      this.router.navigate(['/home']);
    }
    this.screenWidth = window.innerWidth;
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

