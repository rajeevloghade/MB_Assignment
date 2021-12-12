import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/address';
import { Manager } from 'src/manager';
import { ManagerService } from '../manager.service';

@Component({
  selector: 'app-manager-signup',
  templateUrl: './manager-signup.component.html',
  styleUrls: ['./manager-signup.component.css'],
})
export class ManagerSignupComponent implements OnInit {
  public manager = new Manager();
  public address = new Address();
  public submitted = false;

  constructor(private _managerService: ManagerService, private router: Router) {}

  ngOnInit(): void {}

  onSubmit() {
    this.managerSignup();
  }
  managerSignup() {
    this.submitted = true;
    this.manager.address = this.address;
    this._managerService
      .managerSignup(this.manager)
      .subscribe((response: any) => {
        console.log(response);
        this.reset();
        if (response != null) this.redirectToManagerLogin();
        else this.redirectToManagerSignUp();
      });
  }
  redirectToManagerLogin() {
    this.router.navigate(['/managerLogin']);
  }
  redirectToManagerSignUp() {
    this.router.navigate(['/managerSignUp']);
  }

  private reset() {
    console.log('Resetting');
    (this.manager.firstName = ''),
      (this.manager.lastName = ''),
      (this.manager.email = ''),
      (this.manager.password = ''),
      (this.manager.mobile = ''),
      (this.manager.dob = ''),
      (this.manager.company = ''),
      (this.address.street = ''),
      (this.address.city = ''),
      (this.address.state = ''),
      (this.address.pinCode = '');
  }

}
