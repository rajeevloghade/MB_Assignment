import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/address';
import { Manager } from 'src/manager';

@Component({
  selector: 'app-manager-signup',
  templateUrl: './manager-signup.component.html',
  styleUrls: ['./manager-signup.component.css'],
})
export class ManagerSignupComponent implements OnInit {
  public manager = new Manager();
  public address = new Address();
  public submitted = false;

  constructor(private route: Router) {}

  ngOnInit(): void {}

  redirectToManagerLogin() {
    this.route.navigate(['/managerLogin']);
  }

  onSubmit() {}
}
