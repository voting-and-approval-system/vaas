import { Component } from '@angular/core';
import { AdminServicesService } from '../admin-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {
  data = [];


  constructor(private _adminService: AdminServicesService, private _router: Router) { }

  ngOnInit(): void {
    this.getFeedback();
  }

  getFeedback() {
    this._adminService.getFeedback().subscribe(
      (res) => {
        this.data = res;
      });
  }

}
