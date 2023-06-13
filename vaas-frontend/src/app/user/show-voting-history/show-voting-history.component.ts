import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserServicesService } from '../user-services.service';

@Component({
  selector: 'app-show-voting-history',
  templateUrl: './show-voting-history.component.html',
  styleUrls: ['./show-voting-history.component.css']
})
export class ShowVotingHistoryComponent {
  roundData = [];
  userData: any = [];
  resultData: any = [];
  errorMessage = '';
  currentCollapseIndex: number = -1;

  async ngOnInit(): Promise<void> {
    try {
      const res: any = await this._userService.findUserByEmail(localStorage.getItem('userEmail')).toPromise();
      this.userData = res;
    } catch (error) {
      console.error(error);
    }
    await this.displayUserVoteRound(this.userData.id);
  }

  constructor(private _userService: UserServicesService, private _router: Router) { }

  displayUserVoteRound(userId: number) {
    this._userService.displayUserVoteRound(this.userData.id).subscribe(
      (res: any) => {
        this.roundData = res;
      });
  }

  viewResult(issueId: number, roundNumber: number, index: number) {
    if (this.currentCollapseIndex === index) {
      this.currentCollapseIndex = -1;
    } else {
      this.currentCollapseIndex = index;
      this._userService.displayUserOptionList(issueId, roundNumber, this.userData.id).subscribe({
        next: (res: any) => {
          this.resultData = res;
        },
        error: (err: any) => {
          this.resultData = [];
        }
      });
    }
  }
}
