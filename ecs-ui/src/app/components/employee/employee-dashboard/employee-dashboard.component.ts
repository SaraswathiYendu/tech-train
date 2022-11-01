import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {
  employee: Employee;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getUser(localStorage.getItem('token'))
    .subscribe({
      next: (data)=>{
        this.employee = data;
      },
      error: ()=> {}
    });
  }

}
