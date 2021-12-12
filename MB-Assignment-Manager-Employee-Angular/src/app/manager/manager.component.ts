import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manager } from 'src/manager';
import { Response } from 'src/Response';
import { ManagerService } from '../manager.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css'],
})
export class ManagerComponent implements OnInit {
  public loginStatus: any = false;
  public manager = new Manager();
  public loginFailed: boolean = false;

  constructor(
    private _managerService: ManagerService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  managerLoginVerification() {
    console.log(this.manager.email, this.manager.password);
    this._managerService
      .managerLoginVerification(this.manager.email, this.manager.password)
      .subscribe((response: Response) => {
        this.loginStatus = response.status;
        this.manager = response.payload;
        console.log('login Status : ', this.loginStatus);
        if (this.loginStatus) {
          this.redirectToEmployeeList(this.manager.managerId);
        } else {
          this.loginFailed = true;
          this.redirectToManagerLogin();
        }
      });
  }
  redirectToManagerLogin() {
    this.router.navigate(['/managerLogin']);
  }
  redirectToEmployeeList(managerId: number) {
    this.router.navigate(['/employeeList', managerId]);
  }
  redirectToManagerSignUp() {
    this.router.navigate(['/managerSignUp']);
  }

  onSubmit() {
    this.managerLoginVerification();
  }
}
