import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminServicesService } from '../admin-services.service';

@Component({
  selector: 'app-option',
  templateUrl: './option.component.html',
  styleUrls: ['./option.component.css']
})
export class OptionComponent implements OnInit {
  data = [];
  issueId : number;

  constructor(private _adminService: AdminServicesService, private _router: Router,private _route : ActivatedRoute) { }

  ngOnInit(): void {
    this.issueId = Number(this._route.snapshot.paramMap.get('id'));
    this.getOptions(this.issueId);
  }

  getOptions(issueId : number) {
    this._adminService.getOptions(issueId).subscribe(
      (res) => {
        this.data = res;
      });
  }

  editOption(id: number) {
    this._router.navigate(['/admin/addoption', { id: id }]);
  }

  addOption(issueId : number){
    this._router.navigate(['/admin/addoption', { issueId: issueId }]);
  }

  deleteOption(id: number) {
    this._adminService.deleteOption(id).subscribe({
      next: (res) => {
        alert("Record Deleted !!");
        this.getOptions(this.issueId);
      },
      error: (err) => {
        console.log("Error While Delete : " + err);
      }
    })
  }
}