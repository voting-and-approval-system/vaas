import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserAuthService {
  getPreferdRole: any;
  constructor() { }

  public setRoles(roles: any[]) {
    localStorage.setItem('roles', JSON.stringify(roles));
  }

  public getRoles(): any[] {
    const rolesString = localStorage.getItem('roles');
    return rolesString ? JSON.parse(rolesString) : [];
  }

  public setToken(jwtToken: string) {
    localStorage.setItem('jwtToken', jwtToken);
  }

  public getToken(): string | null {
    return localStorage.getItem('jwtToken');
  }

  public clear() {
    localStorage.clear();
  }

  public isLoggedIn() {
    return this.getToken() !== null;
  }

  public setPreferdRole(role: string) {
    localStorage.setItem('preferedRole', role);
  }
}
