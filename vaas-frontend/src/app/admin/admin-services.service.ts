import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserAuthService } from '../_services/user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminServicesService {

  constructor(private _http : HttpClient,private _userAuthService : UserAuthService) { }
  headers = new HttpHeaders()
      .set('Authorization', `Bearer ${this._userAuthService.getToken()}`)
      .set('Content-Type', 'application/json');

  basrUrl = "http://localhost:8080";

  getAssets() : Observable<any> {
    return this._http.get(this.basrUrl + '/assets',{headers : this.headers});
  }

  addAssets(data : any) {
    return this._http.post(this.basrUrl + '/assets',data,{headers : this.headers});
  }

  deleteAssets(id : number){
    return this._http.delete(this.basrUrl + `/assets/${id}`,{headers : this.headers});
  }

  findAssetsById(id : number) : Observable<any> {
    return this._http.get(this.basrUrl + `/assets/${id}`,{headers : this.headers});
  }

  updateAssets(id : number,data : any){
    return this._http.put(this.basrUrl + `/assets/${id}`,data,{headers : this.headers});
  }

  getVoteTypes() : Observable<any> {
    return this._http.get(this.basrUrl + '/votetype',{headers : this.headers});
  }

  findVoteTypeById(id : number) : Observable<any>{
    return this._http.get(this.basrUrl + `/votetype/${id}`,{headers : this.headers});
  }

  getIssues() : Observable<any> {
    return this._http.get(this.basrUrl + '/issue',{headers : this.headers});
  }

  addIssues(data : any) {
    return this._http.post(this.basrUrl + '/issue',data,{headers : this.headers});
  }
  updateIssues(id : number,data : any){
    return this._http.put(this.basrUrl + `/issue/${id}`,data,{headers : this.headers});
  }
  findIssuesById(id : number): Observable<any>{
    return this._http.get(this.basrUrl + `/issue/${id}`,{headers : this.headers});
  }

  deleteIssues(id : number){
    return this._http.delete(this.basrUrl + `/issue/${id}`,{headers : this.headers});
  }

  getOptions() : Observable<any> {
    return this._http.get(this.basrUrl + '/option',{headers : this.headers});
  }

  addOption(data : any) {
    return this._http.post(this.basrUrl + '/option',data,{headers : this.headers});
  }

  updateOption(id : number,data : any){
    return this._http.put(this.basrUrl + `/option/${id}`,data,{headers : this.headers});
  }
  findOptionById(id : number): Observable<any>{
    return this._http.get(this.basrUrl + `/option/${id}`,{headers : this.headers});
  }
  deleteOption(id : number){
    return this._http.delete(this.basrUrl + `/option/${id}`,{headers : this.headers});
  }

  addRound(data : any){
    return this._http.post(this.basrUrl + '/round',data,{headers : this.headers});
  }

  getUsers() : Observable<any> {
    return this._http.get(this.basrUrl + '/users',{headers : this.headers});
  }

  getRoles() : Observable<any> {
    return this._http.get(this.basrUrl + '/roles',{headers : this.headers});
  }

  findRoleById(id : number): Observable<any>{
    return this._http.get(this.basrUrl + `/roles/${id}`,{headers : this.headers});
  }

  addRole(data : any){
    return this._http.post(this.basrUrl + '/userrole',data,{headers : this.headers});
}


}
