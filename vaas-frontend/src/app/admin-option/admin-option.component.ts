import { Component } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';

@Component({
  selector: 'app-admin-option',
  templateUrl: './admin-option.component.html',
  styleUrls: ['./admin-option.component.css']
})
export class AdminOptionComponent {
  constructor(public userAuthService : UserAuthService){}
}
