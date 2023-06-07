import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserServicesService } from '../user-services.service';

@Component({
  selector: 'app-show-result',
  templateUrl: './show-result.component.html',
  styleUrls: ['./show-result.component.css']
})
export class ShowResultComponent implements OnInit {
  resultData = [];
  totalVoteData = [];
  errorMessage = '';

  ngOnInit(): void {
    const roundNumber: any = this._route.snapshot.paramMap.get('roundNumber');
    const issueId: any = this._route.snapshot.paramMap.get('issueId');

    this._userService.displayResult(issueId, roundNumber).subscribe({
      next: (res: any) => {
        this.errorMessage = '';
        this.resultData = res;
        console.log("Result : " + JSON.stringify(this.resultData));
      },
      error: (err: any) => {
        this.resultData = [];
        this.errorMessage = "There is no exact Winner For This Issue, New Voting Round Will be Live Soon !!";
      }
    });

    this._userService.getTotalVote(issueId, roundNumber).subscribe({
      next: (res: any) => {
        this.errorMessage = '';
        this.totalVoteData = res;
        console.log("Total Vote : " + JSON.stringify(this.totalVoteData));
      },
      error: (err: any) => {
        console.log(err);
      }
    });
  }

  constructor(private _userService: UserServicesService, private _route: ActivatedRoute) { }
}
