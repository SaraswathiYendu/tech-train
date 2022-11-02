import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Employee } from "../models/employee.model";
import { Leave } from "../models/leave.model";
import { Manager } from "../models/manager.model";
import { ResponseMsg } from "../models/response-message.model";
 @Injectable({
  providedIn: 'root'
})
export class ManagerService{


  constructor(private http: HttpClient){ }

  fetchAllManagers() : Observable<Manager[]>{
    return this.http.get<Manager[]>(environment.serverUrl+ '/manager/all');
  }

  getManagerInfo(token: string): Observable<Manager> {
    let header={'Authorization':'Basic '+token};
    return this.http.get<Manager>(environment.serverUrl+ '/manager/one' , {headers: header});
  }

  getAllEmployeeNotHavingAccess(token: string): Observable<Employee[]>  {
    let header={'Authorization':'Basic '+token};
    return this.http.get<Employee[]>(environment.serverUrl+ '/employee/manager/all' , {headers: header});

  }

  grantAccess(employeeId: number, token: string) : Observable<ResponseMsg>{
    let header={'Authorization':'Basic '+token};
    return this.http.put<ResponseMsg>(environment.serverUrl+ '/employee/grant-access/' + employeeId, {}, {headers: header});
  }

  getAllPendingLeaves(token: string, status: string): Observable<Leave[]> {
    let header={'Authorization':'Basic '+token};
    return this.http.get<Leave[]>(environment.serverUrl+ '/leave/pending/all/' + status, {headers: header});
  }

  updateStatus(token: string, id: number, status: string) : Observable<any>{
    let header={'Authorization':'Basic '+token};
     return this.http.put(environment.serverUrl+ '/leave/update/status/'+id+'/'+status,{}, {headers: header} );
  }
}
//put post: take body
