import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/employee.model';
import { ManagerService } from 'src/app/services/manager.service';

@Component({
  selector: 'app-manager-access',
  templateUrl: './access.component.html',
  styleUrls: ['./access.component.css']
})
export class AccessComponent implements OnInit {

  employees: Employee[];
  constructor(private managerService: ManagerService) { }

  ngOnInit(): void {
    this.managerService.getAllEmployeeNotHavingAccess(localStorage.getItem('token'))
    .subscribe({
      next: (data)=>{
        this.employees = data;
      },
      error: (error)=>{

      }
    });
  }

}
