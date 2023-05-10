import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  PATH_OF_API = 'http://localhost:8080';

  requestHeader = new HttpHeaders({ 'No-Auth': 'True' });
  constructor(
    private httpclient: HttpClient,
    private userAuthService: UserAuthService
  ) {}

  

  public login(loginData: any) {
    return this.httpclient.post(this.PATH_OF_API + '/authenticate', loginData, {
      headers: this.requestHeader,
    });
  }

  public register(newUser: any) {
    return this.httpclient.post(this.PATH_OF_API + '/user', newUser);
  }


  public roleMatch(allowedRoles: string[]): boolean {
    const userRoles: string[] = this.userAuthService.getRoles();
    
    if (userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        if (allowedRoles.includes(userRoles[i])) {
          return true;
        }
      }
    }
    
    return false;
  }
  
}
