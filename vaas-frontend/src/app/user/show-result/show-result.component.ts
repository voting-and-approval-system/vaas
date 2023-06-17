import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserServicesService } from '../user-services.service';
import { Chart, registerables } from 'chart.js';
import { FormBuilder, FormGroup } from '@angular/forms';
import { formatDate } from '@angular/common';
import { CoreService } from 'src/app/_services/core.service';
Chart.register(...registerables);


@Component({
  selector: 'app-show-result',
  templateUrl: './show-result.component.html',
  styleUrls: ['./show-result.component.css']
})
export class ShowResultComponent implements OnInit {
  resultData: any = [];
  totalVoteData: any = [];
  errorMessage = '';
  chartErrorMessage = '';
  feedback: boolean = false;
  issueData: any = [];
  feedbackFrom: FormGroup;
  userData: any = [];

  async ngOnInit(): Promise<void> {
    const roundNumber: any = this._route.snapshot.paramMap.get('roundNumber');
    const issueId: any = this._route.snapshot.paramMap.get('issueId');

    try {
      this.issueData = await this._userService.displayIssueById(issueId).toPromise();
    } catch (err) {
      this.errorMessage = err.error.message;
    }

    try {
      this.userData = await this._userService.findUserByEmail(localStorage.getItem('userEmail')).toPromise();
    } catch (err) {
      this.errorMessage = err.error.message;
    }

    try {
      this.resultData = await this._userService.displayResult(issueId, roundNumber).toPromise();
    } catch (err) {
      this.errorMessage = err.error.message;
    }

    try {
      this.totalVoteData = await this._userService.getTotalVote(issueId, roundNumber).toPromise();
    } catch (err) {
      this.chartErrorMessage = err.error.message;
    }
    this.renderChart();

    if (this.issueData.allowFeedback && this.errorMessage == '') {
      this.feedback = true;
    }

  }

  constructor(private _userService: UserServicesService, private _route: ActivatedRoute, private _formBuilder: FormBuilder, private _coreService: CoreService) {
    this.feedbackFrom = this._formBuilder.group({
      feedbackDescription: '',
      user: '',
      issue: '',
      feedbackDate: formatDate(new Date(), 'yyyy-MM-dd', 'en-US')
    })
  }

  renderChart(): void {
    const ctx: HTMLCanvasElement | null = document.getElementById('piechart') as HTMLCanvasElement | null;
    if (ctx) {
      const labels: string[] = this.totalVoteData.map((data: any) => data.optionTitle);
      const data: number[] = this.totalVoteData.map((data: any) => data.count);

      new Chart(ctx, {
        type: 'pie',
        data: {
          labels: labels,
          datasets: [{
            label: 'Total Votes',
            data: data,
          }]
        }
      });
    }
  }

  addFeedback() : any{
    const description = this.feedbackFrom.get('feedbackDescription').value;

    if (description == '') {
      this._coreService.openSnackBar("Please Fill Feedback !!");
    } else {
      this.feedbackFrom.get('user').setValue(this.userData);
      this.feedbackFrom.get('issue').setValue(this.issueData);

      return this._userService.addFeedback(this.feedbackFrom.value).subscribe({
        next: (val: any) => {
          this._coreService.openSnackBar("Feedback Added !!");
          this.feedbackFrom.reset();
        },
        error: (err) => {
          console.log("Error while Add Assets : " + err);
          this.feedbackFrom.reset();
        }
      });
    }
  }
}
