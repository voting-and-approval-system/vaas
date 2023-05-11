import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { UserAuthService } from '../_services/user-auth.service';
import { AssetsComponent } from './assets/assets.component';


@NgModule({
  declarations: [
    AssetsComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
