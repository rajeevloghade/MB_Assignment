import { HttpClient, HttpParams } from '@angular/common/http';
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

  deleteEmployee(employeeId: number) {
    return this._httpService.delete(this.url + 'deleteEmployee/' + employeeId);
  }

  getEmployeeById(employeeId: number) {
    return this._httpService.get<Employee>(
      this.url + 'getEmployeeById/' + employeeId
    );
  }

  addEmployee(employee: Employee) {
    let header = { 'content-type': 'application/json' };
    let options = { headers: header };
    console.log(employee);
    return this._httpService.post(this.url + 'addEmployee', employee, options);
  }

  updateEmployee(employee: Employee) {
    return this._httpService.put<Employee>(
      this.url + 'updateEmployee',
      employee
    );
  }

  searchEmployee(employeeName: string ) {
    let params = new HttpParams();
    params = params.append('name', employeeName);
    return this._httpService.get<Employee[]>(this.url + 'searchEmployee', {
      params: params,
    });
  }
}
