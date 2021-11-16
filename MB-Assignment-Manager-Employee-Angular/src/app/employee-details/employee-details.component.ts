import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Employee } from 'src/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css'],
})
export class EmployeeDetailsComponent implements OnInit {
  public employee: Employee | undefined;
  public employeeId: number | undefined;

  constructor(
    private _employeeService: EmployeeService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.employeeId = parseInt(param.get('employeeId') as string);
      this.getEmployeeById(this.employeeId);
    });
  }

  getEmployeeById(employeeId: number) {
    this._employeeService
      .getEmployeeById(employeeId)
      .subscribe((employeeById) => {
        this.employee = employeeById;
        console.log(this.employee);
      });
  }
}
