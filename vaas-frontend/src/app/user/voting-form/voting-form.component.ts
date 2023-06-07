import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServicesService } from '../user-services.service';
import { formatDate } from '@angular/common';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-voting-form',
  templateUrl: './voting-form.component.html',
  styleUrls: ['./voting-form.component.css']
})
export class VotingFormComponent implements OnInit {
  roundData: any = [];
  optionData: any = [];
  userData: any = [];
  votingForm: FormGroup;
  votingData: any = {
    userId: '',
    roundId: '',
    voteDate: formatDate(new Date(), 'yyyy-MM-dd', 'en-US'),
    votePreferences: [{
      optionId: '',
      preference: ''
    }],
  }


  constructor(private _route: ActivatedRoute, private _router: Router, private _userService: UserServicesService, private _formBuilder: FormBuilder) {
    this.votingForm = this._formBuilder.group({
      optionId: '',
      preference: '',
    })
  }

  async ngOnInit(): Promise<void> {
    try {
      const roundId: any = this._route.snapshot.paramMap.get('roundId');
      const resRound: any = await this._userService.displayRoundById(roundId).toPromise();
      this.roundData = resRound;

      const resUserData: any = await this._userService.findUserByEmail(localStorage.getItem('userEmail')).toPromise();
      this.userData = resUserData;

      const resOption: any = await this._userService.displayOptionForIssue(this.roundData.issue.id).toPromise();
      this.optionData = resOption.map((option: any) => {
        return {
          id: option.id,
          optionTitle: option.optionTitle,
          isSelected: false
        };
      });
    } catch (error) {
      console.error(error);
    }
  }

  voting() : any{
    this.votingData.userId = this.userData.id;
    this.votingData.roundId = this.roundData.id;
    this.votingData.votePreferences = this.optionData.filter(x => x.isSelected != false).map((option: any) => {
      return {
        optionId: option.id
      }
    });

    if (this.votingData.votePreferences != '') {
      return this._userService.voting(this.votingData).subscribe({
        next: (res) => {
          this._router.navigate(['/user/voting']);
        },
        error: (err) => {
          console.log(err);
        }
      });
    } else {
      alert("Please select any option for vote !!");
    }
  }
}