import { Component, OnInit } from '@angular/core';
import { Leave } from 'src/app/models/leave.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-eleave-list',
  templateUrl: './eleave-list.component.html',
  styleUrls: ['./eleave-list.component.css']
})
export class EleaveListComponent implements OnInit {

   leaves: Leave[];
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getLeaves(localStorage.getItem('token')).subscribe({
      next: (data)=>{
        this.leaves = data
      },
      error: (error)=>{

      }
    })
  }

  onArchive(id: number){

  }
}
