import { NgModule, NgZone } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user.component';
import { VotingComponent } from './voting/voting.component';
import { VotingFormComponent } from './voting-form/voting-form.component';
import { ResultComponent } from './result/result.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { TenantAuthGuard } from '../_services/user-auth.guard';
import { ShowResultComponent } from './show-result/show-result.component';
import { ShowVotingHistoryComponent } from './show-voting-history/show-voting-history.component';

const routes: Routes = [
  {
    path: '',
    component: UserComponent,
    canActivate: [TenantAuthGuard], // Apply AuthGuard to the parent route
    children: [
      { path: 'user/voting', component: VotingComponent },
      { path: 'user/votingForm', component: VotingFormComponent },
      { path: 'user/result', component: ResultComponent },
      { path: 'user/home', component: UserHomeComponent },
      { path: 'user/profile', component: UserProfileComponent },
      { path: 'user/show-result', component: ShowResultComponent },
      { path: 'user/voting-history', component: ShowVotingHistoryComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule {
  router: any;

  constructor(private ngZone: NgZone) {} // Inject NgZone into the constructor

  navigate(route: string): void {
    this.ngZone.run(() => {
      this.router.navigateByUrl(route);
    });
  }
}