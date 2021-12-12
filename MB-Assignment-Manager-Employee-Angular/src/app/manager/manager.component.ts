import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manager } from 'src/manager';
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

  constructor(private _managerService: ManagerService, private router: Router) {}

  ngOnInit(): void {}

  managerLoginVerification() {
    console.log(this.manager.email, this.manager.password);
    this._managerService
      .managerLoginVerification(this.manager.email, this.manager.password)
      .subscribe((status) => {
        this.loginStatus = status;
        console.log('login Status : ', this.loginStatus);
        if (this.loginStatus) {
          this.redirectToEmployeeList();
        } else {
          this.loginFailed = true;
          this.redirectToManagerLogin();
        }
      });
  }
  redirectToManagerLogin() {
    this.router.navigate(['/managerLogin']);
  }
  redirectToEmployeeList() {
    this.router.navigate(['/employeeList']);
  }
  redirectToManagerSignUp() {
    this.router.navigate(['/managerSignUp']);
  }

  onSubmit() {
    this.managerLoginVerification();
  }
}
