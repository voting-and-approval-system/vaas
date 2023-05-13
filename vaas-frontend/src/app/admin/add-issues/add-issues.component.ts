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
  assets: any;
  voteTypes: any;
  
  constructor(private _formBuilder : FormBuilder,private _adminService : AdminServicesService,
    private _router : Router,private _route : ActivatedRoute){
    this.issuesForm = this._formBuilder.group({
      issueTitle : '',
      issueDescription : '',
      issueAttachmentPath : '',
      allowMultipleOptions : '',
      issueIsActive : '',
      allowFeedback : '',
      voteType : '',
      asset : ''
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
    this.assets = res; // Assign the response to the assets variable
  });
}

getVoteTypes() {
  this._adminService.getVoteTypes().subscribe((res) => {
    this.voteTypes = res; // Assign the response to the voteTypes variable
  });
}

addIssues(){

  const title = this.issuesForm.get('issueTitle').value;
  const description = this.issuesForm.get('issueDescription').value;
  const atachmentpath = this.issuesForm.get('issueAttachmentPath').value;
  const allowMultipleOptions = this.issuesForm.get('allowMultipleOptions').value;
  const asset = this.issuesForm.get('asset').value;
  const issueIsActive = this.issuesForm.get('issueIsActive').value;
  const voteType = this.issuesForm.get('voteType').value;
  const allowFeedback = this.issuesForm.get('allowFeedback').value;
  // if(title == ''){
  //   alert("Please Add Title");
  //   return null;
  // }
  // if(description == ''){
  //   alert("Please Add Description");
  //   return null;
  // }
  // if(atachmentpath == ''){
  //   alert("Please Add atachmentpath");
  //   return null;
  // }
  // if(allowMultipleOptions == ''){
  //   alert("Please Add Description");
  //   return null;
  // }
  // if(asset == ''){
  //   alert("Please select asset");
  //   return null;
  // }
  // if(issueIsActive == ''){
  //   alert("Please Add allowMultipleOptions");
  //   return null;
  // }
  // if(voteType == ''){
  //   alert("Please select voteType");
  //   return null;
  // }
  // if(allowFeedback == ''){
  //   alert("Please Add allowFeedback");
  //   return null;
  // }
  return this._adminService.addIssues(this.issuesForm.value).subscribe({
    next : (val : any) => {
      alert("issues Added !!");
      this._router.navigate(['/admin/issues']);
      this.issuesForm.reset();
    },
    error : (err) =>{
      console.log("Error while Add issues : " + err);
      this.issuesForm.reset();
    }
  });

}


updateIssues(id : number){
  return this._adminService.updateIssues(id,this.issuesForm.value).subscribe({
    next : (val : any) => {
      alert("Issues Updated !!");
      this._router.navigate(['/admin/issues']);
      this.issuesForm.reset();
    },
    error : (err) =>{
      console.log("Error while Add Assets : " + err);
      this.issuesForm.reset();
    }
  });
}

}


