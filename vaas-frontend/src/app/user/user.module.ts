import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { DemoComponent } from './demo/demo.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    DemoComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
