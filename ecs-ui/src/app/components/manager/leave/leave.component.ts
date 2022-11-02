import { Component, OnInit } from '@angular/core';
import { Leave } from 'src/app/models/leave.model';
import { ManagerService } from 'src/app/services/manager.service';

@Component({
  selector: 'app-manager-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent implements OnInit {

  leaves: Leave[];
  msg: string;
  constructor(private managerService: ManagerService) { }

  ngOnInit(): void {
    this.managerService.getAllPendingLeaves(localStorage.getItem('token'), 'PENDING')
    .subscribe({
      next: (data)=>{
        this.leaves = data;
      },
      error: ()=>{}
    });
  }

  onStatusUpdate(id:number, status: string){
      this.managerService.updateStatus(localStorage.getItem('token'),id,status)
      .subscribe({
        next: ()=>{
          this.msg='Status Updated';
          this.leaves = this.leaves.filter(l=>l.id !== id);
        },
        error: ()=>{
          this.msg='Could not update Status, please try later.';
        }
      });
  }
}
