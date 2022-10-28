import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/models/employee.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http: HttpClient) { }

  postEmployee(employee: Employee, managerId: number) : Observable<any>{
    return this.http.post<any>(environment.serverUrl + '/employee/add/'+ managerId
    , employee);
  }

}
