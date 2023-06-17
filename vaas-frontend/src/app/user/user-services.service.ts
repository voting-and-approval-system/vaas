import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from '../_services/user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserServicesService {

  constructor(private _http: HttpClient, private _userAuthService: UserAuthService) { }
  headers = new HttpHeaders()
    .set('Authorization', `Bearer ${this._userAuthService.getToken()}`)
    .set('Content-Type', 'application/json');

  baseUrl = 'https://d2zoc2f04048nn.cloudfront.net/api';

  findUserByEmail(userEmail: string) {
    return this._http.get(this.baseUrl + `/users/${userEmail}`, { headers: this.headers });
  }

  displayRound(userId: number) {
    return this._http.get(this.baseUrl + `/round/user/${userId}`, { headers: this.headers });
  }

  displayIssueById(id: number) {
    return this._http.get(this.baseUrl + `/issue/${id}`, { headers: this.headers });
  }

  displayOptionForIssue(issueId: any) {
    return this._http.get(this.baseUrl + `/option/issue/${issueId}`, { headers: this.headers });
  }

  displayRoundById(roundId: number) {
    return this._http.get(this.baseUrl + `/round/${roundId}`, { headers: this.headers });
  }

  voting(data: any) {
    return this._http.post(this.baseUrl + '/voting', data, { headers: this.headers });
  }

  displayDeactiveRounds() {
    return this._http.get(this.baseUrl + '/round/deactive', { headers: this.headers });
  }

  displayResult(issueId: number, roundNumber: number) {
    return this._http.get(this.baseUrl + `/result/${issueId}/${roundNumber}`, { headers: this.headers });
  }

  getTotalVote(issueId: number, roundNumber: number) {
    return this._http.get(this.baseUrl + `/voteoption/findtotalvote/${issueId}/${roundNumber}`, { headers: this.headers });
  }

  displayUserVoteRound(userId : number){
    return this._http.get(this.baseUrl + `/round/uservote/${userId}`, { headers: this.headers });
  }

  displayUserOptionList(issueId: number, roundNumber: number,userId : number){
    return this._http.get(this.baseUrl + `/voteoption/getUserOptionList/${issueId}/${roundNumber}/${userId}`, { headers: this.headers });
  }

  addFeedback(data : any){
    return this._http.post(this.baseUrl + '/feedback',data, { headers: this.headers });
  }
}
