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
   msg:string;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getLeaves();
    this.employeeService.leave$.subscribe({
      next: (data)=>{
        this.getLeaves();
      }
    });
  }

  onArchive(id: number){
        this.employeeService.archiveLeave(localStorage.getItem('token'), id)
        .subscribe({
          next: (data)=>{
            this.msg='Record Archived';
            this.leaves = this.leaves.filter(l=>l.id !== id);
          },
          error: (error)=>{
            this.msg = error.error.msg;
          }
        })
  }

  getLeaves(){
    this.employeeService.getLeaves(localStorage.getItem('token')).subscribe({
      next: (data)=>{
        this.leaves = data
      },
      error: (error)=>{

      }
    });
  }
}
