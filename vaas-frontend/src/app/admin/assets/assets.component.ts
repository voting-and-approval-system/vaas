import { Component, OnInit } from '@angular/core';
import { AdminServicesService } from '../admin-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-assets',
  templateUrl: './assets.component.html',
  styleUrls: ['./assets.component.css']
})
export class AssetsComponent implements OnInit {
  data = [];


  constructor(private _adminService: AdminServicesService, private _router: Router) { }

  ngOnInit(): void {
    this.getAssets();
  }



  getAssets() {
    this._adminService.getAssets().subscribe(
      (res) => {
        this.data = res;
      });
  }

  deleteAssets(id: number) {
    this._adminService.deleteAssets(id).subscribe({
      next: (res) => {
        alert("Record Deleted !!");
        this.getAssets();
      },
      error: (err) => {
        console.log("Error While Delete : " + err);
      }
    })
  }

  editAssets(id: number) {
    this._router.navigate(['/admin/addassets', {id : id}]);
  }
}
