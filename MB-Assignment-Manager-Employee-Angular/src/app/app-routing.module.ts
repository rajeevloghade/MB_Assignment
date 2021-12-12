import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeCreateComponent } from './employee-create/employee-create.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeEditComponent } from './employee-edit/employee-edit.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { ManagerDetailsComponent } from './manager-details/manager-details.component';
import { ManagerSignupComponent } from './manager-signup/manager-signup.component';
import { ManagerComponent } from './manager/manager.component';

const routes: Routes = [
  { path: '', redirectTo: 'managerLogin', pathMatch: 'full' },
  { path: 'managerLogin', component: ManagerComponent },
  { path: 'employeeList/:managerId', component: EmployeeListComponent },
  { path: 'employeeDetails/:employeeId', component: EmployeeDetailsComponent },
  { path: 'addEmployee', component: EmployeeCreateComponent },
  { path: 'updateEmployee/:employeeId', component: EmployeeEditComponent },
  { path: 'managerSignUp', component: ManagerSignupComponent },
  { path: 'managerDetails/:managerId', component: ManagerDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
export const routingComponents = [
  ManagerComponent,
  ManagerSignupComponent,
  ManagerDetailsComponent,
  EmployeeListComponent,
  EmployeeDetailsComponent,
  EmployeeCreateComponent,
  EmployeeEditComponent
];