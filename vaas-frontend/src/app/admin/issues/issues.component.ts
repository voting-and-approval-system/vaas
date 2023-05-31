import { Component, OnInit } from '@angular/core';
import { AdminServicesService } from '../admin-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-issues',
  templateUrl: './issues.component.html',
  styleUrls: ['./issues.component.css']
})



export class IssuesComponent implements OnInit {
  data = [];


  constructor(private _adminService: AdminServicesService, private _router: Router) { }

  ngOnInit(): void {
    this.getIssues();
  }



  getIssues() {
    this._adminService.getIssues().subscribe(
      (res) => {
        this.data = res;
        console.log(JSON.stringify(this.data));
      });
  }

  editIssues(id: number) {
    this._router.navigate(['/admin/addissues', { id: id }]);
  }


  deleteIssues(id: number) {
    this._adminService.deleteIssues(id).subscribe({
      next: (res) => {
        alert("Record Deleted !!");
        this.getIssues();
      },
      error: (err) => {
        console.log("Error While Delete : " + err);
      }
    })
  }
}