import { NgModule, NgZone } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AssetsComponent } from './assets/assets.component';
import { AddAssetsComponent } from './add-assets/add-assets.component';
import { VoteTypesComponent } from './vote-types/vote-types.component';
import { IssuesComponent } from './issues/issues.component';
import { AddIssuesComponent } from './add-issues/add-issues.component';
import { OptionComponent } from './option/option.component';
import { AddOptionComponent } from './add-option/add-option.component';
import { ShowUserComponent } from './show-user/show-user.component';
import { VoteRoundComponent } from './vote-round/vote-round.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { AuthGuard } from '../_services/auth.guard';
import { ResultRevotingComponent } from './result-revoting/result-revoting.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'admin/assets',
        component: AssetsComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/addassets',
        component: AddAssetsComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/votetypes',
        component: VoteTypesComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/issues',
        component: IssuesComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/addissues',
        component: AddIssuesComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/option',
        component: OptionComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/addoption',
        component: AddOptionComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/showuser',
        component: ShowUserComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/voteround',
        component: VoteRoundComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/feedback',
        component: FeedbackComponent,
        pathMatch: 'full'
      },
      {
        path: 'admin/result',
        component: ResultRevotingComponent,
        pathMatch: 'full'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
  router: any;
  constructor(private ngZone: NgZone) {} // Inject NgZone into the constructor

  navigate(route: string): void {
    this.ngZone.run(() => {
      this.router.navigateByUrl(route);
    });
  }
}
