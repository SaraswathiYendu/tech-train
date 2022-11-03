import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/employee.model';
import { ManagerService } from 'src/app/services/manager.service';

@Component({
  selector: 'app-manager-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  employees: Employee[];
  constructor(private managerService: ManagerService) { }

  ngOnInit(): void {
    this.managerService.fetchAllEmployees(localStorage.getItem('token'))
    .subscribe({
      next: (data)=>{
        this.employees = data;
      }
    })
  }

}
