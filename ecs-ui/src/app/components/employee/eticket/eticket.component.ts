import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Ticket } from 'src/app/models/ticket.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-eticket',
  templateUrl: './eticket.component.html',
  styleUrls: ['./eticket.component.css']
})
export class EticketComponent implements OnInit {

  ticketForm: FormGroup;
  msg:string;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.ticketForm = new FormGroup({
      issue: new FormControl('',Validators.required),
      priority: new FormControl('',Validators.required)
    });
  }

  onTicketSubmit(){

    let ticket = {      //local object
      issue: this.ticketForm.value.issue,
      priority: this.ticketForm.value.priority
    };

    this.employeeService.postTicket(ticket,localStorage.getItem('token') )
    .subscribe({
      next: (data)=>{
        this.msg='Ticket successfully posted';
      },
      error: (error)=>{
        this.msg='Ticket could not be posted, please try later'
      }
    });
  }
}
