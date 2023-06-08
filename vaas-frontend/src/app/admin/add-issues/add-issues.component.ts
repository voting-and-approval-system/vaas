import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminServicesService } from '../admin-services.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CoreService } from 'src/app/_services/core.service';

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
    private _router: Router, private _route: ActivatedRoute,private _coreService : CoreService) {
    this.issuesForm = this._formBuilder.group({
      issueTitle: '',
      issueDescription: '',
      issueAttachmentPath: '',
      allowMultipleOptions: false,
      issueIsActive: true,
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
        this.issuesForm.patchValue({
          issueTitle: this.data.issueTitle,
          issueDescription: this.data.issueDescription,
          allowMultipleOptions: this.data.allowMultipleOptions,
          issueIsActive: this.data.issueIsActive,
          allowFeedback: this.data.allowFeedback,
          voteType: this.data.voteType.id,
          assets: this.data.assets ? this.data.assets.id : ''
        });
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
    const assetId = this.issuesForm.get('assets').value || '';
    const voteTypeId = this.issuesForm.get('voteType').value;

    let _assets = [];
    if (assetId != '') {
      try {
        const assetRes: any = await this._adminService.findAssetsById(assetId).toPromise();
        _assets = assetRes;
      } catch (err) {
        console.log("Error while fetching assets: " + JSON.stringify(err));
      }
      this.issuesForm.get('assets').setValue(_assets);
    } else {
      this.issuesForm.removeControl('assets');
    }

    let _voteType = [];
    try {
      const voteTypeRes: any = await this._adminService.findVoteTypeById(voteTypeId).toPromise();
      _voteType = voteTypeRes;
    } catch (err) {
      console.log("Error while fetching vote type: " + JSON.stringify(err));
    }
    this.issuesForm.get('voteType').setValue(_voteType);

    try {
      const val = await this._adminService.addIssues(this.issuesForm.value).toPromise();
      const issueId = await this._adminService.getLastAddedIssueId().toPromise();
      this.round.issue.id = issueId.toString();
      const addRound = await this._adminService.addRound(this.round).toPromise();

      this._coreService.openSnackBar("Issue Added !!");
      this._router.navigate(['/admin/issues']);
      this.issuesForm.reset();
    } catch (err) {
      console.log("Error while adding issues: " + JSON.stringify(err));
      this.issuesForm.reset();
    }
  }

  async updateIssues(id: number) {

    const assetId = this.issuesForm.get('assets').value || '';
    const voteTypeId = this.issuesForm.get('voteType').value;

    let _assets = [];
    if (assetId != '') {
      try {
        const assetRes: any = await this._adminService.findAssetsById(assetId).toPromise();
        _assets = assetRes;
      } catch (err) {
        console.log("Error while fetching assets: " + JSON.stringify(err));
      }
      this.issuesForm.get('assets').setValue(_assets);
    } else {
      this.issuesForm.removeControl('assets');
    }

    let _voteType = [];
    try {
      const voteTypeRes: any = await this._adminService.findVoteTypeById(voteTypeId).toPromise();
      _voteType = voteTypeRes;
    } catch (err) {
      console.log("Error while fetching vote type: " + JSON.stringify(err));
    }
    this.issuesForm.get('voteType').setValue(_voteType);

    try {
      const val = await this._adminService.updateIssues(id, this.issuesForm.value).toPromise();
      this._coreService.openSnackBar("Issue Updated !!");
      this._router.navigate(['/admin/issues']);
      this.issuesForm.reset();
    } catch (err) {
      console.log("Error while Updating issues: " + JSON.stringify(err));
      this.issuesForm.reset();
    }
  }
}