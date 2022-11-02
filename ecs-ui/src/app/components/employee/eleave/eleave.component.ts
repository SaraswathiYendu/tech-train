import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-eleave',
  templateUrl: './eleave.component.html',
  styleUrls: ['./eleave.component.css']
})
export class EleaveComponent implements OnInit {
  leaveForm: FormGroup;
  msg: string;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.leaveForm = new FormGroup({
      fromDate: new FormControl('', Validators.required),
      toDate: new FormControl('', Validators.required),
      numDays: new FormControl('', Validators.required)
    });
  }

  onLeaveSubmit(){
     let leave={
      fromDate: this.leaveForm.value.fromDate,
      toDate: this.leaveForm.value.toDate,
      numDays: this.leaveForm.value.numDays
     };

     this.employeeService.postLeave(leave, localStorage.getItem('token'))
     .subscribe({
      next: (data)=>{
        this.msg='Leave Applied'
        this.employeeService.leave$.next(leave);
      },
      error: ()=>{
        this.msg='Application could not be processed'
      }
     });
  }
}
