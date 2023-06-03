import { Component, OnInit } from '@angular/core';
import { UserServicesService } from '../user-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css']
})
export class VotingComponent implements OnInit {
  userData: any = [];
  roundData: any = [];

  constructor(private _userService: UserServicesService, private _router: Router) { }

  async ngOnInit(): Promise<void> {
    try {
      const res: any = await this._userService.findUserByEmail(localStorage.getItem('userEmail')).toPromise();
      this.userData = res;
    } catch (error) {
      console.error(error);
    }
    await this.displayRound(this.userData.id);
  }

  vote(roundId: number) {
    this._router.navigate(['/user/votingForm', { roundId: roundId }]);
  }

  displayRound(id: number) {
    this._userService.displayRound(id).subscribe(
      (res: any) => {
        this.roundData = res;
      });
  }

}
