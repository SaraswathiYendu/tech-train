import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/models/ticket.model';
import { ManagerService } from 'src/app/services/manager.service';

@Component({
  selector: 'app-manager-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {

  tickets: Ticket[];

  constructor(private managerService: ManagerService) { }

  ngOnInit(): void {
    this.managerService.fetchAllTickets(localStorage.getItem('token'))
    .subscribe({
      next: (data)=>{
        this.tickets = data;
      },
      error: ()=>{

      }
    });
  }

}
