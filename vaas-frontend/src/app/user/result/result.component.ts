import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServicesService } from '../user-services.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit{
  roundData = [];
  resultData : any = [];
  
  ngOnInit(): void {
    this.displayRound();
  }

  constructor(private _userService : UserServicesService,private _router : Router){}

  displayRound(){
    this._userService.displayDeactiveRounds().subscribe(
      (res : any) => {
        this.roundData = res;
      });
  }

  viewResult(issueId : number,roundNumber : number){
    this._userService.displayResult(issueId,roundNumber).subscribe(
      (res : any) => {
        this.resultData = res;
        console.log(this.resultData);
      });
  }

}
