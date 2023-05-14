import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServicesService } from '../user-services.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-voting-form',
  templateUrl: './voting-form.component.html',
  styleUrls: ['./voting-form.component.css']
})
export class VotingFormComponent implements OnInit {
  roundData : any = [];
  optionData : any = [];
  votingForm : FormGroup;


  constructor(private _route: ActivatedRoute, private _router: Router, private _userService: UserServicesService,private _formBuilder : FormBuilder) {
    this.votingForm = this._formBuilder.group({
      userId : '',
      roundId : '',
      voteDate : '',
      votePreferences : ''
    })
   }

  async ngOnInit() : Promise<void> {
    try {
      const roundId : any =  this._route.snapshot.paramMap.get('roundId');
      const resRound : any = await this._userService.displayRoundById(roundId).toPromise();
      this.roundData = resRound;

      const resOption : any = await this._userService.displayOptionForIssue(this.roundData.issue.id).toPromise();
      this.optionData = resOption;
    } catch (error) {
      console.error(error);
    }
  }

  voting(){

  }

}
