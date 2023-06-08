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
      });
  }

  editIssues(id: number) {
    this._router.navigate(['/admin/addissues', { id: id }]);
  }

  viewOptions(id: number){
    this._router.navigate(['/admin/option', { id: id }]);
  }

  updateStatus(id : number,isActive : boolean){
    isActive = isActive ? false : true;
    this._adminService.updateIssueIsActive(id,isActive).subscribe({
      next : (res) => {
        alert("Status is Updated !!");
        this.getIssues();
      }
    });
  }
}