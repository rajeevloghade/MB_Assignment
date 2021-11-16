import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/employee';
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

  constructor(private _managerService: ManagerService) {}

  ngOnInit(): void {}

  managerLoginVerification() {
    console.log(this.manager.email, this.manager.password);
    this._managerService
      .managerLoginVerification(this.manager.email, this.manager.password)
      .subscribe((status) => {
        this.loginStatus = status;
        console.log('login Status : ', this.loginStatus);
        if(this.loginStatus){
          this.redirectToEmployeeList();
        }else{

        }
      });
  }
  redirectToEmployeeList() {
    throw new Error('Method not implemented.');
  }

  onSubmit() {
    this.managerLoginVerification();
  }
}
