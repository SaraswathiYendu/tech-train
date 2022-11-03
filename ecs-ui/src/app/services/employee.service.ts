import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";
import { environment } from "src/environments/environment";
import {Employee} from '../models/employee.model'
import { Leave } from "../models/leave.model";
import { Ticket } from "../models/ticket.model";
@Injectable({
  providedIn: 'root'
})
export class EmployeeService{

  leave$ = new BehaviorSubject<Leave>({});

  constructor(private http: HttpClient){ }

  getUser(token: string): Observable<Employee> {
    let header={'Authorization':'Basic '+token};
     return this.http.get<Employee>(environment.serverUrl + '/employee/one', {headers: header});
  }

  postTicket(ticket: { issue: any; priority: any; }, token: string) : Observable<any>{
    let header={'Authorization':'Basic '+token};
    return this.http.post(environment.serverUrl + '/ticket/add',ticket, {headers: header});
  }

  postLeave(leave: { fromDate: any; toDate: any; numDays: any; }, token: string): Observable<any> {
    let header={'Authorization':'Basic '+token};
    return this.http.post(environment.serverUrl + '/leave/add', leave, {headers: header});
  }

  getLeaves(token: string): Observable<Leave[]> {
    let header={'Authorization':'Basic '+token};
     return this.http.get<Leave[]>(environment.serverUrl + '/leave/all', {headers: header});
  }

  archiveLeave(token: string, id: number) : Observable<any>{
    let header={'Authorization':'Basic '+token};
    return this.http.put(environment.serverUrl
      + '/leave/update/archive/' + id + '/true', {},{headers: header} );
  }

  fetchTickets(token: string): Observable<Ticket[]> {
    let header={'Authorization':'Basic '+token};
    return this.http.get<Ticket[]>(environment.serverUrl+'/ticket/employee/all', {headers: header});
  }
}
