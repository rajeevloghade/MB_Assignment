import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Address } from 'src/address';
import { Employee } from 'src/employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css'],
})
export class EmployeeEditComponent implements OnInit {
  private employeeId: number | undefined;
  public employee: Employee = new Employee();
  public address: Address = new Address();

  constructor(
    private _employeeService: EmployeeService,
    private router: ActivatedRoute,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.router.paramMap.subscribe((param: ParamMap) => {
      this.employeeId = parseInt(param.get('employeeId') as string);
      this.getEmployeeById(this.employeeId);
    });
  }

  getEmployeeById(employeeId: number) {
    this._employeeService
      .getEmployeeById(employeeId)
      .subscribe((employeeById) => {
        this.employee = employeeById;
        this.address = this.employee.address;
        console.log(this.employee);
      });
  }

  onSubmit() {
    this.updateEmployee();
  }

  updateEmployee() {
    this._employeeService
      .updateEmployee(this.employee)
      .subscribe((employeeData) => {
        (this.employee = employeeData),
          console.log('updated emp: ', this.employee);
      });
  }

  gotoEmployeeList() {
    this.route.navigate(['employeeList']);
  }
}
