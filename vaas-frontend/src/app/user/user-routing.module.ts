import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user.component';
import { VotingComponent } from './voting/voting.component';
import { VotingFormComponent } from './voting-form/voting-form.component';
import { ResultComponent } from './result/result.component';
import { UserHomeComponent } from './user-home/user-home.component';

const routes: Routes = [
  {
    path: '',
    component: UserComponent,
    children: [
      { path: 'user/voting', component: VotingComponent },
      { path: 'user/votingForm', component: VotingFormComponent },
      { path: 'user/result', component: ResultComponent },
      { path: 'user/home', component: UserHomeComponent }

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
