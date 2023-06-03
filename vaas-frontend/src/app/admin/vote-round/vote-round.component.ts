import { Component } from '@angular/core';
import { AdminServicesService } from '../admin-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vote-round',
  templateUrl: './vote-round.component.html',
  styleUrls: ['./vote-round.component.css']
})
export class VoteRoundComponent {
  data = [];

constructor(private _adminService: AdminServicesService, private _router: Router) { }

  ngOnInit(): void {
    this.getVoteRound();
  }

  getVoteRound() {
    this._adminService.getVoteRound().subscribe(
      (res) => {
        this.data = res;
      });
  }

  updateStatus(id : number,isActive : boolean){
    isActive = isActive ? false : true;
    this._adminService.updateRoundIsActive(id,isActive).subscribe({
      next : (res) => {
        alert("Status is Updated !!");
        this.getVoteRound();
      }
    });
  }
}