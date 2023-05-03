import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  PATH_OF_API = "http://localhost:8080";

  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  )
  constructor(private httpclient: HttpClient) { }

  public login(loginData: any){
    return this.httpclient.post(this.PATH_OF_API + "/authenticate", loginData, { headers: this.requestHeader })
  }
}
