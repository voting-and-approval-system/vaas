import { NgModule, NgZone } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { AdminOptionComponent } from './admin-option/admin-option.component';
import { PendingUserComponent } from './pending-user/pending-user.component';
import { AuthGuard } from './_services/auth.guard';
import { TenantAuthGuard } from './_services/user-auth.guard';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard] },
  { path: 'adminoption', component: AdminOptionComponent },
  { path: '', component: HomeComponent },
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'user', component: UserComponent, canActivate: [TenantAuthGuard] },
  { path: 'pending', component: PendingUserComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    scrollPositionRestoration: 'enabled',
    anchorScrolling: 'enabled',
    scrollOffset: [0, 64],
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {
  router: any;
  constructor(private ngZone: NgZone) { } 

  navigate(route: string): void {
    this.ngZone.run(() => {
      this.router.navigateByUrl(route);
    });
  }
}