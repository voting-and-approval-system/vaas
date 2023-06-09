import { Component, OnInit } from '@angular/core';
import { AdminServicesService } from '../admin-services.service';
import { Router } from '@angular/router';
import { CoreService } from 'src/app/_services/core.service';

@Component({
  selector: 'app-result-revoting',
  templateUrl: './result-revoting.component.html',
  styleUrls: ['./result-revoting.component.css']
})
export class ResultRevotingComponent implements OnInit {
  roundData = [];
  resultData: any = [];
  errorMessage = '';
  currentCollapseIndex: number = -1;
  roundNumber: number;
  issueData: any;
  newRound: { issue: any[], roundNumber: number, roundIsActive: true } = { issue: [], roundNumber: 0, roundIsActive: true };

  ngOnInit(): void {
    this.displayRound();
  }

  constructor(private _adminService: AdminServicesService,private _router : Router,private _coreService : CoreService) { }

  displayRound() {
    this._adminService.displayDeactiveRounds().subscribe(
      (res: any) => {
        this.roundData = res;
      });
  }

  viewResult(issueId: number, roundNumber: number, index: number) {
    if (this.currentCollapseIndex === index) {
      this.currentCollapseIndex = -1;
    } else {
      this.currentCollapseIndex = index;
      this._adminService.displayResult(issueId, roundNumber).subscribe({
        next: (res: any) => {
          this.errorMessage = '';
          this.resultData = res;
        },
        error: (err: any) => {
          this.resultData = [];
          this.errorMessage = err.error.message;
        }
      });
    }
  }

  async revoting(id: number) {
    try {
      const roundNumberResponse: any = await this._adminService.lastRoundNumber(id).toPromise();
      this.roundNumber = roundNumberResponse;
    } catch (error) {
      console.log(error.error);
    }

    try {
      const issueDataResponse = await this._adminService.findIssuesById(id).toPromise();
      this.issueData = issueDataResponse;
    } catch (error) {
      console.log(error.error);
    }

    this.newRound.issue = this.issueData;
    this.newRound.roundNumber = this.roundNumber + 1;
    const issueDataResponse = await this._adminService.addRound(this.newRound).toPromise();
    this._coreService.openSnackBar("New Round is set");
    this._router.navigate(['admin/result']);
  }

}
