import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServicesService } from '../admin-services.service';

@Component({
  selector: 'app-vote-types',
  templateUrl: './vote-types.component.html',
  styleUrls: ['./vote-types.component.css']
})
export class VoteTypesComponent implements OnInit {
  data = [];


  constructor(private _adminService: AdminServicesService, private _router: Router) { }

  ngOnInit(): void {
    this.getVoteTypes();
  }



  getVoteTypes() {
    this._adminService.getVoteTypes().subscribe(
      (res) => {
        this.data = res;
      });
  }

}