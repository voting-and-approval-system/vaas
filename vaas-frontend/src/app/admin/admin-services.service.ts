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

  findAssetsById(id : number){
    return this._http.get(this.basrUrl + `/assets/${id}`,{headers : this.headers});
  }

  updateAssets(id : number,data : any){
    return this._http.put(this.basrUrl + `/assets/${id}`,data,{headers : this.headers});
  }
}
