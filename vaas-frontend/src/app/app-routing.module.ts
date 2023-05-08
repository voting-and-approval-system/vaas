import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AdminOptionComponent } from './admin-option/admin-option.component';

const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'admin', component:AdminComponent},
  {path:'user', component:UserComponent},
  {path:'', component:LoginComponent},
  {path:'login', component:LoginComponent},
  {path:'forbidden', component:ForbiddenComponent},
  {path:'adminoption', component:AdminOptionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
