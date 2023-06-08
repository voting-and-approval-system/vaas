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

  editAssets(id: number) {
    this._router.navigate(['/admin/addassets', { id: id }]);
  }
}