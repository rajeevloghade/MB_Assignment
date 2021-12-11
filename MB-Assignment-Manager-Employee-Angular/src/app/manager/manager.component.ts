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
  public loginMode: boolean = false;

  constructor(private _managerService: ManagerService, private route: Router) {}

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
    this.route.navigate(['/managerLogin']);
  }
  redirectToEmployeeList() {
    this.route.navigate(['/employeeList']);
  }
  redirectToManagerSignUp() {
    this.route.navigate(['/managerSignUp']);
  }

  onSubmit() {
    console.log('loginMode : ', this.loginMode);
    this.managerLoginVerification();
  }
  onModeSwitch() {
    this.loginMode = !this.loginMode;
    console.log('loginMode : ', this.loginMode);
  }
}
