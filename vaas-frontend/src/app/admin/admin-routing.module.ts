import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AssetsComponent } from './assets/assets.component';
import { AddAssetsComponent } from './add-assets/add-assets.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {path: 'admin/assets',component:AssetsComponent},
      {path: 'admin/addassets',component : AddAssetsComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
