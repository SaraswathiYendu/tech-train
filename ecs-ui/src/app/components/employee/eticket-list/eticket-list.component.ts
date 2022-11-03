import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/models/ticket.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-eticket-list',
  templateUrl: './eticket-list.component.html',
  styleUrls: ['./eticket-list.component.css']
})
export class EticketListComponent implements OnInit {

  tickets: Ticket[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.fetchTickets(localStorage.getItem('token'))
    .subscribe({
      next: (data)=>{
        this.tickets = data;
      },
      error: ()=>{}
    });
  }

}
