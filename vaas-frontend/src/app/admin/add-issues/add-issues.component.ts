import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AdminServicesService } from '../admin-services.service';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: 'app-add-issues',
  templateUrl: './add-issues.component.html',
  styleUrls: ['./add-issues.component.css']
})

export class AddIssuesComponent implements OnInit{
  issuesForm : FormGroup;
  data = null;
  assetsData : any;
  voteTypesData : any;
  
  constructor(private _formBuilder : FormBuilder,private _adminService : AdminServicesService,
    private _router : Router,private _route : ActivatedRoute){
    this.issuesForm = this._formBuilder.group({
      issueTitle : '',
      issueDescription : '',
      issueAttachmentPath : '',
      allowMultipleOptions : false,
      issueIsActive : false,
      allowFeedback : false,
      voteType : '',
      assets : ''
    })
  }

  ngOnInit() {
    const data = this._route.snapshot.paramMap.get('id');
    this.getAssets();
    this.getVoteTypes();
    
    if(data != null){
      this._adminService.findIssuesById(Number(data)).subscribe({
        next : (val : any) => {
          this.data = val;
        }
      });
    }
}


getAssets() {
  this._adminService.getAssets().subscribe((res) => {
    this.assetsData = res; // Assign the response to the assets variable
  });
}

getVoteTypes() {
  this._adminService.getVoteTypes().subscribe((res) => {
    this.voteTypesData = res; // Assign the response to the voteTypes variable
  });
}

// addIssues(){

//   const title = this.issuesForm.get('issueTitle').value;
//   const description = this.issuesForm.get('issueDescription').value;
//   const atachmentpath = this.issuesForm.get('issueAttachmentPath').value;
//   const allowMultipleOptions = this.issuesForm.get('allowMultipleOptions').value;
//   const assetId = this.issuesForm.get('asset').value;
//   const issueIsActive = this.issuesForm.get('issueIsActive').value;
//   const voteTypeId = this.issuesForm.get('voteType').value;
//   const allowFeedback = this.issuesForm.get('allowFeedback').value;

//   let _assets = [];
//   this._adminService.findAssetsById(assetId).subscribe({
//     next : (res : any) => {
//       _assets = res;
//       console.log("DATA +++ : " + JSON.stringify(_assets))
//     }});

  
//   let _voteType = [];
//   this._adminService.findVoteTypeById(voteTypeId).subscribe({
//     next : (res : any) => {
//       _voteType = res;
//     }});

//   this.issuesForm.get('asset').setValue(_assets);
//   this.issuesForm.get('voteType').setValue(_voteType);

//   console.log("LOG : " + JSON.stringify(_assets));

//   console.log("issueForm : " +  this.issuesForm.value);
//   // if(title == ''){
//   //   alert("Please Add Title");
//   //   return null;
//   // }
//   // if(description == ''){
//   //   alert("Please Add Description");
//   //   return null;
//   // }
//   // if(atachmentpath == ''){
//   //   alert("Please Add atachmentpath");
//   //   return null;
//   // }
//   // if(allowMultipleOptions == ''){
//   //   alert("Please Add Description");
//   //   return null;
//   // }
//   // if(asset == ''){
//   //   alert("Please select asset");
//   //   return null;
//   // }
//   // if(issueIsActive == ''){
//   //   alert("Please Add allowMultipleOptions");
//   //   return null;
//   // }
//   // if(voteType == ''){
//   //   alert("Please select voteType");
//   //   return null;
//   // }
//   // if(allowFeedback == ''){
//   //   alert("Please Add allowFeedback");
//   //   return null;
//   // }

//   console.log("FORM DATA : " + Object.values(this.issuesForm.value));

//   return this._adminService.addIssues(this.issuesForm.value).subscribe({
//     next : (val : any) => {
//       alert("issues Added !!");
//       this._router.navigate(['/admin/issues']);
//       this.issuesForm.reset();
//     },
//     error : (err) =>{
//       console.log("Error while Add issues : " + JSON.stringify(err));
//       this.issuesForm.reset();
//     }
//   });

// }

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
  try {
    const assetRes : any = await this._adminService.findAssetsById(assetId).toPromise();
    _assets = assetRes;
    console.log("DATA +++ : " + JSON.stringify(_assets))
  } catch (err) {
    console.log("Error while fetching assets: " + JSON.stringify(err));
  }

  let _voteType = [];
  try {
    const voteTypeRes : any = await this._adminService.findVoteTypeById(voteTypeId).toPromise();
    _voteType = voteTypeRes;
    console.log("GGG : " + JSON.stringify(_voteType))
  } catch (err) {
    console.log("Error while fetching vote type: " + JSON.stringify(err));
  }

  this.issuesForm.get('assets').setValue(_assets);

  this.issuesForm.get('voteType').setValue(_voteType);

  console.log("LOG : " + JSON.stringify(_assets));

  console.log("issueForm : " +  this.issuesForm.value);

  console.log("FORM DATA : " + Object.values(this.issuesForm.value));

  try {
    const val = await this._adminService.addIssues(this.issuesForm.value).toPromise();
    alert("issues Added !!");
    this._router.navigate(['/admin/issues']);
    this.issuesForm.reset();
  } catch (err) {
    console.log("Error while adding issues: " + JSON.stringify(err));
    this.issuesForm.reset();
  }
}



async updateIssues(id : number) {


  this.issuesForm.get('issueTitle').setValue(this.data.issueTitle);
  this.issuesForm.get('issueDescription').setValue(this.data.issueDescription);
  this.issuesForm.get('issueAttachmentPath').setValue(this.data.issueAttachmentPath);
  this.issuesForm.get('allowMultipleOptions').setValue(this.data.allowMultipleOptions);
  this.issuesForm.get('issueIsActive').setValue(this.data.issueIsActive);
  this.issuesForm.get('allowFeedback').setValue(this.data.allowFeedback);
  
  
  const assetId = this.issuesForm.get('assets').value;
  const voteTypeId = this.issuesForm.get('voteType').value;
  console.log("print Data : " +JSON.stringify(this.issuesForm.value));

  let _assets = [];
  try {
    const assetRes: any = await this._adminService.findAssetsById(assetId).toPromise();
    _assets = assetRes;
    console.log("DATA +++ : " + JSON.stringify(_assets))
  } catch (err) {
    console.log("Error while fetching assets: " + JSON.stringify(err));
  }

  let _voteType = [];
  try {
    const voteTypeRes: any = await this._adminService.findVoteTypeById(voteTypeId).toPromise();
    _voteType = voteTypeRes;
    console.log("GGG : " + JSON.stringify(_voteType))
  } catch (err) {
    console.log("Error while fetching vote type: " + JSON.stringify(err));
  }

  this.issuesForm.get('assets').setValue(_assets);
  this.issuesForm.get('voteType').setValue(_voteType);

  console.log("LOG : " + JSON.stringify(_voteType));
  console.log("NILAY  " + JSON.stringify(this.issuesForm.value));

  try {
    const val = await this._adminService.updateIssues(id,this.issuesForm.value).toPromise();
    alert("issues Updated !!");
    this._router.navigate(['/admin/issues']);
    this.issuesForm.reset();
  } catch (err) {
    console.log("Error while adding issues: " + JSON.stringify(err));
    this.issuesForm.reset();
  }
}


}


