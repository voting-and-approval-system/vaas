import { Component } from '@angular/core';
import { AdminServicesService } from '../admin-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-user',
  templateUrl: './show-user.component.html',
  styleUrls: ['./show-user.component.css']
})
export class ShowUserComponent {
  data = [];


  constructor(private _adminService: AdminServicesService, private _router: Router) { }

  ngOnInit(): void {
    this.getUsers();
  }



  getUsers() {
    this._adminService.getUsers().subscribe(
      (res) => {
        this.data = res;
      });
  }


  editRole(id: number) {
    this._router.navigate(['admin/userrole', {id : id}]);
  }
}
