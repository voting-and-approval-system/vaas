import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  PATH_OF_API = 'https://ec2-52-51-82-19.eu-west-1.compute.amazonaws.com:8080';

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
