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
  issueData: any;



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

  ngOnInit() {
    const data = this._route.snapshot.paramMap.get('id');
    this.getIssues();


    if (data != null) {
      this._adminService.findOptionById(Number(data)).subscribe({
        next: async (val: any) => {
          this.data = val;
        }
      });
    }
  }


  getIssues() {
    this._adminService.getIssues().subscribe(
      (res) => {
        this.issueData = res;
        console.log("DATA : " + JSON.stringify(this.issueData));
      });
  }


  async addOption() {
    const title = this.optionForm.get('optionTitle').value;
    const description = this.optionForm.get('optionDescription').value;
    const atachmentpath = this.optionForm.get('optionAttachmentPath').value;
    const issueId = this.optionForm.get('issue').value;
    const optionIsActive = this.optionForm.get('optionIsActive').value;

    let _issue = [];
    try {
      const issueRes: any = await this._adminService.findIssuesById(issueId).toPromise();
      _issue = issueRes;
      console.log("DATA +++ : " + JSON.stringify(issueId))
    } catch (err) {
      console.log("Error while fetching issue: " + JSON.stringify(err));
    }



    this.optionForm.get('issue').setValue(_issue);


    console.log("LOG : " + JSON.stringify(issueId));

    console.log("optionForm : " + this.optionForm.value);

    console.log("FORM DATA : " + Object.values(this.optionForm.value));

    try {
      const val = await this._adminService.addOption(this.optionForm.value).toPromise();
      alert("options Added !!");
      this._router.navigate(['/admin/option']);
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
        this.optionForm.get('optionTitle').setValue(this.data.optionTitle);
        this.optionForm.get('optionDescription').setValue(this.data.optionDescription);
        this.optionForm.get('optionAttachmentPath').setValue(this.data.optionAttachmentPath);
        this.optionForm.get('optionIsActive').setValue(this.data.optionIsActive);


        const issueId = this.optionForm.get('issue').value;
        const issueRes: any = await this._adminService.findIssuesById(issueId).toPromise();
        _issue = issueRes;

      } catch (err) {
        console.error("Error while fetching issue: " + JSON.stringify(err));
      }

      this.optionForm.get('issue').setValue(_issue);

      const val = await this._adminService.updateOption(id, this.optionForm.value).toPromise();
      alert("options Updated !!");
      this._router.navigate(['/admin/option']);
      this.optionForm.reset();
    } catch (err) {
      console.error("Error while adding option: " + JSON.stringify(err));
      this.optionForm.reset();
    }
  }

}