import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Employee } from "../models/employee.model";
import { Manager } from "../models/manager.model";

@Injectable({
  providedIn: 'root'
})
export class ManagerService{

  constructor(private http: HttpClient){

  }
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
}
