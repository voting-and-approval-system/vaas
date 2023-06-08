import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminServicesService } from '../admin-services.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CoreService } from 'src/app/_services/core.service';

@Component({
  selector: 'app-add-assets',
  templateUrl: './add-assets.component.html',
  styleUrls: ['./add-assets.component.css']
})
export class AddAssetsComponent implements OnInit {
  assetsForm: FormGroup;
  data = null;

  constructor(private _formBuilder: FormBuilder, private _adminService: AdminServicesService, private _router: Router, private _route: ActivatedRoute,private _coreService : CoreService) {
    this.assetsForm = this._formBuilder.group({
      assetsTitle: '',
      assetsDescription: ''
    })
  }

  ngOnInit() {
    const data = this._route.snapshot.paramMap.get('id');

    if (data != null) {
      this._adminService.findAssetsById(Number(data)).subscribe({
        next: (val: any) => {
          this.data = val;
        }
      });
    }
  }

  addAssets() {
    const title = this.assetsForm.get('assetsTitle').value;
    const description = this.assetsForm.get('assetsDescription').value;
    if (title == '') {
      alert("Please Add Title");
      return null;
    }
    if (description == '') {
      alert("Please Add Description");
      return null;
    }
    return this._adminService.addAssets(this.assetsForm.value).subscribe({
      next: (val: any) => {
        this._coreService.openSnackBar("Assets Add !!");
        this._router.navigate(['/admin/assets']);
        this.assetsForm.reset();
      },
      error: (err) => {
        console.log("Error while Add Assets : " + err);
        this.assetsForm.reset();
      }
    });
  }

  updateAssets(id: number) {
    return this._adminService.updateAssets(id, this.assetsForm.value).subscribe({
      next: (val: any) => {
        this._coreService.openSnackBar("Assets Updated !!");
        this._router.navigate(['/admin/assets']);
        this.assetsForm.reset();
      },
      error: (err) => {
        console.log("Error while Add Assets : " + err);
        this.assetsForm.reset();
      }
    });
  }
}