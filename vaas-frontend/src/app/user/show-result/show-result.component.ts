import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserServicesService } from '../user-services.service';
import { Chart, registerables } from 'chart.js';
Chart.register(...registerables);


@Component({
  selector: 'app-show-result',
  templateUrl: './show-result.component.html',
  styleUrls: ['./show-result.component.css']
})
export class ShowResultComponent implements OnInit {
  resultData:any = [];
  totalVoteData: any = [];
  errorMessage = '';
  chartErrorMessage = '';

  async ngOnInit(): Promise<void> {
    const roundNumber: any = this._route.snapshot.paramMap.get('roundNumber');
    const issueId: any = this._route.snapshot.paramMap.get('issueId');

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
  }

  constructor(private _userService: UserServicesService, private _route: ActivatedRoute) { }
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
}
