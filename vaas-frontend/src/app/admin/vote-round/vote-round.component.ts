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


  deactivateRound(id: number) {
  
      this._adminService.deactivateRound(id).subscribe({
        next: (res) => {
          alert("Round Dactivated !!");
          this.getVoteRound();
        },
        error: (err) => {
          console.log("Error While Delete : " + err);
        }
      })
    

}
}