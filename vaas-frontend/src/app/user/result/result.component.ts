import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServicesService } from '../user-services.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  roundData = [];
  resultData: any = [];
  errorMessage = '';
  currentCollapseIndex: number = -1;

  ngOnInit(): void {
    this.displayRound();
  }

  constructor(private _userService: UserServicesService,private _router : Router) { }

  displayRound() {
    this._userService.displayDeactiveRounds().subscribe(
      (res: any) => {
        this.roundData = res;
      });
  }

  viewResult(issueId: number, roundNumber: number, index: number) {
    if (this.currentCollapseIndex === index) {
      this.currentCollapseIndex = -1;
    } else {
      this.currentCollapseIndex = index;
      this._userService.displayResult(issueId, roundNumber).subscribe({
        next: (res: any) => {
          this.errorMessage = 'There is no exact Winner For This Issue, New Voting Round Will be Live Soon !!"';
          this.resultData = res;
        },
        error: (err: any) => {
          this.resultData = [];
          this.errorMessage = "There is no exact Winner For This Issue, New Voting Round Will be Live Soon !!";
        }
      });
    }
    this._router.navigate(['/user/show-result', { issueId : issueId, roundNumber : roundNumber }]);
  }
}
