import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private url = 'http://localhost:8085/emp/';

  constructor(private _httpService: HttpClient) {}

  getAllEmployee() {
    return this._httpService.get<Employee[]>(this.url + 'getAllEmployee');
  }
}
