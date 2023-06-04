import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminServicesService } from '../admin-services.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-option',
  templateUrl: './add-option.component.html',
  styleUrls: ['./add-option.component.css']
})
export class AddOptionComponent implements OnInit {
  optionForm: FormGroup;
  data = null;
  issueId : number;

  constructor(private _formBuilder: FormBuilder, private _adminService: AdminServicesService,
    private _router: Router, private _route: ActivatedRoute) {
    this.optionForm = this._formBuilder.group({
      optionTitle: '',
      optionDescription: '',
      optionAttachmentPath: '',
      issue: '',
      optionIsActive: true
    })
  }

  async ngOnInit() {
    const data = this._route.snapshot.paramMap.get('id');
    this.issueId = Number(this._route.snapshot.paramMap.get('issueId'));

    if (data != null) {
      try {
        this.data = await this._adminService.findOptionById(Number(data)).toPromise();
      } catch (err) {
        console.error("Error while fetching option: " + JSON.stringify(err));
      }
    }
  
    if (this.data) {
      this.optionForm.patchValue({
        optionTitle: this.data.optionTitle,
        optionDescription: this.data.optionDescription,
        optionAttachmentPath: this.data.optionAttachmentPath,
        issue: this.data.issue.id,
        optionIsActive: this.data.optionIsActive
      });
    }
  }
  
  async addOption() {
    let _issue = [];
    try {
      const issueRes: any = await this._adminService.findIssuesById(this.issueId).toPromise();
      _issue = issueRes;
    } catch (err) {
      console.log("Error while fetching issue: " + JSON.stringify(err));
    }
    this.optionForm.get('issue').setValue(_issue);

    try {
      const val = await this._adminService.addOption(this.optionForm.value).toPromise();
      alert("options Added !!");
      console.log(this.issueId);
      this._router.navigate(['/admin/option', { id: this.issueId }]);
      this.optionForm.reset();
    } catch (err) {
      console.log("Error while adding option: " + JSON.stringify(err));
      this.optionForm.reset();
    }
  }



  async updateOption(id: number) {
    try {
      let _issue = [];
      try {
        this.issueId = this.optionForm.get('issue').value;
        const issueRes: any = await this._adminService.findIssuesById(this.issueId).toPromise();
        _issue = issueRes;
      } catch (err) {
        console.error("Error while fetching issue: " + JSON.stringify(err));
      }
      this.optionForm.get('issue').setValue(_issue);

      const val = await this._adminService.updateOption(id, this.optionForm.value).toPromise();
      alert("options Updated !!");
      this._router.navigate(['/admin/option', { id: this.issueId }]);
      this.optionForm.reset();
    } catch (err) {
      console.error("Error while adding option: " + JSON.stringify(err));
      this.optionForm.reset();
    }
  }
}