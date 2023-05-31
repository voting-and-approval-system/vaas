import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminServicesService } from '../admin-services.service';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: 'app-add-issues',
  templateUrl: './add-issues.component.html',
  styleUrls: ['./add-issues.component.css']
})

export class AddIssuesComponent implements OnInit {
  issuesForm: FormGroup;
  data = null;
  assetsData: any;
  voteTypesData: any;
  round = { issue: { id: '' }, roundNumber: 1, roundIsActive: true };

  constructor(private _formBuilder: FormBuilder, private _adminService: AdminServicesService,
    private _router: Router, private _route: ActivatedRoute) {
    this.issuesForm = this._formBuilder.group({
      issueTitle: '',
      issueDescription: '',
      issueAttachmentPath: '',
      allowMultipleOptions: false,
      issueIsActive: false,
      allowFeedback: false,
      voteType: '',
      assets: ''
    })
  }

  async ngOnInit(): Promise<void> {
    try {
      const dataId = this._route.snapshot.paramMap.get('id');
      this.getAssets();
      this.getVoteTypes();

      if (dataId != null) {
        const val = await this._adminService.findIssuesById(Number(dataId)).toPromise();
        this.data = val;
      }

      if (this.data) {
        this.issuesForm.patchValue(this.data);
      }
    } catch (err) {
      console.log(err);
    }

  }


  getAssets() {
    this._adminService.getAssets().subscribe((res) => {
      this.assetsData = res;
    });
  }

  getVoteTypes() {
    this._adminService.getVoteTypes().subscribe((res) => {
      this.voteTypesData = res;
    });
  }

  async addIssues() {
    const title = this.issuesForm.get('issueTitle').value;
    const description = this.issuesForm.get('issueDescription').value;
    const atachmentpath = this.issuesForm.get('issueAttachmentPath').value;
    const allowMultipleOptions = this.issuesForm.get('allowMultipleOptions').value;
    const assetId = this.issuesForm.get('assets').value;
    const issueIsActive = this.issuesForm.get('issueIsActive').value;
    const voteTypeId = this.issuesForm.get('voteType').value;
    const allowFeedback = this.issuesForm.get('allowFeedback').value;

    let _assets = [];
    if (assetId != '') {
      try {
        const assetRes: any = await this._adminService.findAssetsById(assetId).toPromise();
        _assets = assetRes;
      } catch (err) {
        console.log("Error while fetching assets: " + JSON.stringify(err));
      }
    }


    let _voteType = [];
    try {
      const voteTypeRes: any = await this._adminService.findVoteTypeById(voteTypeId).toPromise();
      _voteType = voteTypeRes;
    } catch (err) {
      console.log("Error while fetching vote type: " + JSON.stringify(err));
    }

    this.issuesForm.get('assets').setValue(_assets);
    this.issuesForm.get('voteType').setValue(_voteType);


    try {
      const val = await this._adminService.addIssues(this.issuesForm.value).toPromise();
      const issueId = await this._adminService.getLastAddedIssueId().toPromise();
      this.round.issue.id = issueId.toString();
      const addRound = await this._adminService.addRound(this.round).toPromise();

      alert("issues Added !!");
      this._router.navigate(['/admin/issues']);
      this.issuesForm.reset();
    } catch (err) {
      console.log("Error while adding issues: " + JSON.stringify(err));
      this.issuesForm.reset();
    }
  }

  async updateIssues(id: number) {

    console.log("Form Data " + JSON.stringify(this.issuesForm.value));
    console.log("ID " + id);

    const assetId = this.issuesForm.get('assets').value;
    const voteTypeId = this.issuesForm.get('voteType').value;

    console.log("Assets Data : " + JSON.stringify(this.issuesForm.get('assets').value));

    console.log("print Data : " + JSON.stringify(this.issuesForm.value));

    let _assets = [];
    try {
      const assetRes: any = await this._adminService.findAssetsById(assetId).toPromise();
      _assets = assetRes;
    } catch (err) {
      console.log("Error while fetching assets: " + JSON.stringify(err));
    }

    let _voteType = [];
    try {
      const voteTypeRes: any = await this._adminService.findVoteTypeById(voteTypeId).toPromise();
      _voteType = voteTypeRes;
    } catch (err) {
      console.log("Error while fetching vote type: " + JSON.stringify(err));
    }

    this.issuesForm.get('assets').setValue(_assets);
    this.issuesForm.get('voteType').setValue(_voteType);

    console.log("Assets Data : " + JSON.stringify(this.issuesForm.get('assets').value));
    console.log("Vote Type Data : " + JSON.stringify(this.issuesForm.get('voteType').value));


    try {
      const val = await this._adminService.updateIssues(id, this.issuesForm.value).toPromise();
      console.log("Round:" + this.round);

      alert("issues Updated !!");



      this._router.navigate(['/admin/issues']);
      this.issuesForm.reset();
    } catch (err) {
      console.log("Error while Updating issues: " + JSON.stringify(err));
      this.issuesForm.reset();
    }
  }
}