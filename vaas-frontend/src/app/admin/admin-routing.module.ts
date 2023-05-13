import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AssetsComponent } from './assets/assets.component';
import { AddAssetsComponent } from './add-assets/add-assets.component';
import { VoteTypesComponent } from './vote-types/vote-types.component';
import { IssuesComponent } from './issues/issues.component';
import { AddIssuesComponent } from './add-issues/add-issues.component';
import { OptionComponent } from './option/option.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {path: 'admin/assets',component:AssetsComponent},
      {path: 'admin/addassets',component : AddAssetsComponent},
      {path: 'admin/votetypes',component : VoteTypesComponent},
      {path: 'admin/issues',component : IssuesComponent},
      {path: 'admin/addissues',component : AddIssuesComponent},
      {path: 'admin/option',component : OptionComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
