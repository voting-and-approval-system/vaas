import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminServicesService } from '../admin-services.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-userrole',
  templateUrl: './add-userrole.component.html',
  styleUrls: ['./add-userrole.component.css']
})

export class AddUserroleComponent implements OnInit {
  RoleForm: FormGroup;
  data = null;
  roleData : any;

  constructor(private _formBuilder: FormBuilder, private _adminService: AdminServicesService,
    private _router: Router, private _route: ActivatedRoute) {
    this.RoleForm = this._formBuilder.group({
      user: '',
      role: ''
    })
  }

  async ngOnInit(): Promise<void> {
    this.getRoles();
  }


  getRoles() {
    this._adminService.getRoles().subscribe((res) => {
      this.roleData = res; // Assign the response to the assets variable
    });
  }

  async addRole(id: number) {

    const role = this.RoleForm.get('role').value;

    let _role = [];
    try {
      const roleRes: any = await this._adminService.findRoleById(role).toPromise();
      _role = roleRes;
      console.log("DATA +++ : " + JSON.stringify(_role))
    } catch (err) {
      console.log("Error while fetching vote type: " + JSON.stringify(err));
    }

    this.RoleForm.get('role').setValue(_role);
    

  }






}
