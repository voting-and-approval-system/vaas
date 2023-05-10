import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AdminOptionComponent } from './admin-option/admin-option.component';
import { DemoComponent } from './user/demo/demo.component';

const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'admin', component:AdminComponent},
  {path:'', component:HomeComponent},
  {path:'forbidden', component:ForbiddenComponent},
  {path:'adminoption', component:AdminOptionComponent},
  {path: 'user',component: UserComponent},
  {path: 'demo',component:DemoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
