import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpParams,
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ManagerService {
  private url = 'http://localhost:8085/mgr/';

  constructor(private _httpService: HttpClient) {}

  managerLoginVerification(email: string, password: string):Observable<Object> {
    const params = new HttpParams()
      .set('email', email)
      .set('password', password);
    return this._httpService.get(this.url+'managerLoginVerification', { params });
  }
}
