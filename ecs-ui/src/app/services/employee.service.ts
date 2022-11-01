import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import {Employee} from '../models/employee.model'
@Injectable({
  providedIn: 'root'
})
export class EmployeeService{

  constructor(private http: HttpClient){

  }

  getUser(token: string): Observable<Employee> {
    let header={'Authorization':'Basic '+token};
     return this.http.get<Employee>(environment.serverUrl + '/employee/one', {headers: header});
  }
}
