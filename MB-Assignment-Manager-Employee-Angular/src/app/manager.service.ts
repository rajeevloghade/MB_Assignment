import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Manager } from 'src/manager';
import { Response } from 'src/Response';

@Injectable({
  providedIn: 'root',
})
export class ManagerService {
  private url = 'http://localhost:8085/mgr/';

  constructor(private _httpService: HttpClient) {}

  managerLoginVerification(
    email: string,
    password: string
  ): Observable<Response> {
    const params = new HttpParams()
      .set('email', email)
      .set('password', password);
    return this._httpService.get<Response>(
      this.url + 'managerLoginVerification',
      {
        params,
      }
    );
  }

  managerSignup(manager: Manager) {
    let header = { 'content-type': 'application/json' };
    let options = { headers: header };
    console.log(manager);
    return this._httpService.post(this.url + 'managerSignup', manager, options);
  }
  getManagerById(managerId: number) {
    return this._httpService.get<Manager>(
      this.url + 'getManagerByEmployeeId/' + managerId
    );
  }
}
