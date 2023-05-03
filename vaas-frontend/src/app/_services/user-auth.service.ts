import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRoles(roles: []){
    localStorage.setItem('roles', JSON.stringify(roles));
  }

  public getRoles(): [] {
   return JSON.parse(localStorage.getItem('roles'));
  }
}
