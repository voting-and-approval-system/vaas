import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import {MatSnackBarModule} from '@angular/material/snack-bar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HttpClientModule } from '@angular/common/http'
import { RouterModule } from '@angular/router';
import { AdminOptionComponent } from './admin-option/admin-option.component';
import { RegisterComponent } from './register/register.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { UserRoutingModule } from './user/user-routing.module';
import { AdminRoutingModule } from './admin/admin-routing.module';
import { AssetsComponent } from './admin/assets/assets.component';
import { AddAssetsComponent } from './admin/add-assets/add-assets.component';
import { VoteTypesComponent } from './admin/vote-types/vote-types.component';
import { IssuesComponent } from './admin/issues/issues.component';
import { AddIssuesComponent } from './admin/add-issues/add-issues.component';
import { OptionComponent } from './admin/option/option.component';
import { AddOptionComponent } from './admin/add-option/add-option.component';
import { VotingComponent } from './user/voting/voting.component';
import { VotingFormComponent } from './user/voting-form/voting-form.component';
import { ResultComponent } from './user/result/result.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ShowUserComponent } from './admin/show-user/show-user.component';
import { PendingUserComponent } from './pending-user/pending-user.component';
import { VoteRoundComponent } from './admin/vote-round/vote-round.component';
import { UserHomeComponent } from './user/user-home/user-home.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { FeedbackComponent } from './admin/feedback/feedback.component';
import { ResultRevotingComponent } from './admin/result-revoting/result-revoting.component';
import { ShowResultComponent } from './user/show-result/show-result.component';
import { NgxUiLoaderHttpModule, NgxUiLoaderModule } from 'ngx-ui-loader';


const appRoute: Routes = [

];

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
    UserComponent,
    ForbiddenComponent,
    AdminOptionComponent,
    RegisterComponent,
    AssetsComponent,
    AddAssetsComponent,
    VoteTypesComponent,
    IssuesComponent,
    AddIssuesComponent,
    OptionComponent,
    AddOptionComponent,
    VotingComponent,
    VotingFormComponent,
    ResultComponent,
    ShowUserComponent,
    PendingUserComponent,
    VoteRoundComponent,
    UserHomeComponent,
    UserProfileComponent,
    FeedbackComponent,
    ResultRevotingComponent,
    ShowResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    FormsModule,
    UserRoutingModule,
    AdminRoutingModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    NgxUiLoaderModule.forRoot({
      "bgsColor": "red",
      "bgsOpacity": 0.5,
      "bgsPosition": "bottom-right",
      "bgsSize": 60,
      "bgsType": "ball-spin-clockwise",
      "blur": 5,
      "delay": 0,
      "fastFadeOut": true,
      "fgsColor": "red",
      "fgsPosition": "center-center",
      "fgsSize": 60,
      "fgsType": "circle",
      "gap": 24,
      "logoPosition": "center-center",
      "logoSize": 120,
      "logoUrl": "",
      "masterLoaderId": "master",
      "overlayBorderRadius": "0",
      "overlayColor": "rgba(40, 40, 40, 0.8)",
      "pbColor": "red",
      "pbDirection": "ltr",
      "pbThickness": 3,
      "hasProgressBar": true,
      "text": "",
      "textColor": "#FFFFFF",
      "textPosition": "center-center",
      "maxTime": -1,
      "minTime": 300
    }),




    NgxUiLoaderHttpModule.forRoot({ showForeground: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
