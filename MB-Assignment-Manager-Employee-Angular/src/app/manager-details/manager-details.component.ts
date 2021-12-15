import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Manager } from 'src/manager';
import { ManagerService } from '../manager.service';

@Component({
  selector: 'app-manager-details',
  templateUrl: './manager-details.component.html',
  styleUrls: ['./manager-details.component.css'],
})
export class ManagerDetailsComponent implements OnInit {
  public manager = new Manager();
  public managerId: number | undefined;

  constructor(
    private managerService: ManagerService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.managerId = parseInt(this.route.snapshot.paramMap.get('managerId') as string);
    console.log("managerId : ",this.managerId);
    this.getManagerById(this.managerId);
  }

  getManagerById(managerId: number) {
    this.managerService.getManagerById(managerId).subscribe((managerById) => {
      this.manager = managerById;
      console.log(this.manager);
    });
  }
}
