import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  public employees: Employee[] = [];
  constructor(private _employeeService: EmployeeService) {}

  ngOnInit(): void {
    this._employeeService.getAllEmployee().subscribe((employeeList) => {
      this.employees = employeeList;
      console.log(this.employees);
    });
  }
  
}
