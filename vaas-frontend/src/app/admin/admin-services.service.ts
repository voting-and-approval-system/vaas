import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserAuthService } from '../_services/user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminServicesService {

  constructor(private _http: HttpClient, private _userAuthService: UserAuthService) { }
  headers = new HttpHeaders()
    .set('Authorization', `Bearer ${this._userAuthService.getToken()}`)
    .set('Content-Type', 'application/json');

  baseUrl = "http://localhost:8080";

  getAssets(): Observable<any> {
    return this._http.get(this.baseUrl + '/assets', { headers: this.headers });
  }

  addAssets(data: any) {
    return this._http.post(this.baseUrl + '/assets', data, { headers: this.headers });
  }

  deleteAssets(id: number) {
    return this._http.delete(this.baseUrl + `/assets/${id}`, { headers: this.headers });
  }

  findAssetsById(id: number): Observable<any> {
    return this._http.get(this.baseUrl + `/assets/${id}`, { headers: this.headers });
  }

  updateAssets(id: number, data: any) {
    return this._http.put(this.baseUrl + `/assets/${id}`, data, { headers: this.headers });
  }

  getVoteTypes(): Observable<any> {
    return this._http.get(this.baseUrl + '/votetype', { headers: this.headers });
  }

  findVoteTypeById(id: number): Observable<any> {
    return this._http.get(this.baseUrl + `/votetype/${id}`, { headers: this.headers });
  }

  getIssues(): Observable<any> {
    return this._http.get(this.baseUrl + '/issue', { headers: this.headers });
  }

  addIssues(data: any) {
    return this._http.post(this.baseUrl + '/issue', data, { headers: this.headers });
  }

  updateIssues(id: number, data: any) {
    return this._http.put(this.baseUrl + `/issue/${id}`, data, { headers: this.headers });
  }

  findIssuesById(id: number): Observable<any> {
    return this._http.get(this.baseUrl + `/issue/${id}`, { headers: this.headers });
  }

  deleteIssues(id: number) {
    return this._http.delete(this.baseUrl + `/issue/${id}`, { headers: this.headers });
  }

  getOptions(issueId: number): Observable<any> {
    return this._http.get(this.baseUrl + `/option/issue/${issueId}`, { headers: this.headers });
  }

  addOption(data: any) {
    return this._http.post(this.baseUrl + '/option', data, { headers: this.headers });
  }

  updateOption(id: number, data: any) {
    return this._http.put(this.baseUrl + `/option/${id}`, data, { headers: this.headers });
  }

  findOptionById(id: number): Observable<any> {
    return this._http.get(this.baseUrl + `/option/${id}`, { headers: this.headers });
  }

  deleteOption(id: number) {
    return this._http.delete(this.baseUrl + `/option/${id}`, { headers: this.headers });
  }

  addRound(data: any) {
    return this._http.post(this.baseUrl + '/round', data, { headers: this.headers });
  }

  getUsers(): Observable<any> {
    return this._http.get(this.baseUrl + '/newusers', { headers: this.headers });
  }

  getRoles(): Observable<any> {
    return this._http.get(this.baseUrl + '/roles', { headers: this.headers });
  }

  findRoleById(id: number): Observable<any> {
    return this._http.get(this.baseUrl + `/roles/${id}`, { headers: this.headers });
  }

  addUserRole(data: any) {
    return this._http.post(this.baseUrl + '/userrole', data, { headers: this.headers });
  }

  getLastAddedIssueId() {
    return this._http.get(this.baseUrl + '/lastissue', { headers: this.headers });
  }

  getVoteRound(): Observable<any> {
    return this._http.get(this.baseUrl + '/round', { headers: this.headers });
  }

  updateIssueIsActive(issueId: number, isActive: boolean) {
    return this._http.put(this.baseUrl + `/issue/${issueId}/${isActive}`, null, { headers: this.headers });
  }

  updateRoundIsActive(roundId: number, isActive: boolean) {
    return this._http.put(this.baseUrl + `/round/${roundId}/${isActive}`, null, { headers: this.headers });
  }

  getFeedback(): Observable<any> {
    return this._http.get(this.baseUrl + '/feedbacks', { headers: this.headers });
  }

  displayDeactiveRounds() {
    return this._http.get(this.baseUrl + '/round/deactive', { headers: this.headers });
  }

  displayResult(issueId: number, roundNumber: number) {
    return this._http.get(this.baseUrl + `/result/${issueId}/${roundNumber}`, { headers: this.headers });
  }

  lastRoundNumber(issueId : number){
    return this._http.get(this.baseUrl + `/round/lastRoundNumber/${issueId}`, { headers: this.headers });
  }
}