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
  addRoleForm: any;


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

  addRoleAndNavigate(id: number) {
    const data = {
      user: {
        id: id
      },
      role: {
        id: 2
      }
    };

    this._adminService.addUserRole(data).subscribe({
      next: (val: any) => {
        // Reload the current page
        this._router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
          this._router.navigate(['/admin/showuser']);
        });
      },
      error: (err: any) => {
        console.log("Error while assigning role: " + err);
      }
    });
  }

}
