import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  public employees: Employee[] = [];
  public employeeName: string ='';
  constructor(
    private _employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllEmployee();
  }

  getAllEmployee() {
    this._employeeService.getAllEmployee().subscribe((employeeList) => {
      this.employees = employeeList;
      console.log(this.employees);
    });
  }

  deleteEmployee(employeeId: number) {
    this._employeeService.deleteEmployee(employeeId).subscribe((response) => {
      console.log(response);
      this.getAllEmployee();
    });
  }

  getEmployeeById(employeeId: number) {
    this.router.navigate(['employeeDetails', employeeId]);
  }

  goToAddEmployee() {
    this.router.navigate(['addEmployee']);
  }
  updateEmployee(employeeId: number) {
    this.router.navigate(['updateEmployee', employeeId]);
  }

  searchEmployee() {
    console.log(this.employeeName);
    this._employeeService
      .searchEmployee(this.employeeName)
      .subscribe((employeeByName) => {
        this.employees = employeeByName;
        console.log(this.employees);
      });
  }
}
