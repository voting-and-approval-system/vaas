import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServicesService } from '../admin-services.service';

@Component({
  selector: 'app-option',
  templateUrl: './option.component.html',
  styleUrls: ['./option.component.css']
})
export class OptionComponent implements OnInit {
  data = [];


  constructor(private _adminService: AdminServicesService, private _router: Router) { }

  ngOnInit(): void {
    this.getOptions();
  }



  getOptions() {
    this._adminService.getOptions().subscribe(
      (res) => {
        this.data = res;
      });
  }

  editOption(id: number) {
    this._router.navigate(['/admin/addoption', {id : id}]);
  }


  deleteOption(id: number) {
    this._adminService.deleteOption(id).subscribe({
      next: (res) => {
        alert("Record Deleted !!");
        this.getOptions();
      },
      error: (err) => {
        console.log("Error While Delete : " + err);
      }
    })
  }
}