import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  PATH_OF_API = 'https://d2zoc2f04048nn.cloudfront.net/api';

  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(
    private httpclient: HttpClient,
    private userAuthService: UserAuthService
  ) { }



  public login(loginData: any) {
    return this.httpclient.post(this.PATH_OF_API + '/authenticate', loginData, {
      headers: this.requestHeader,
    });
  }

  public register(newUser: any) {
    return this.httpclient.post(this.PATH_OF_API + '/user', newUser);
  }
}
