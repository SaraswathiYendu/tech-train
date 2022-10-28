import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/models/employee.model';
import { User } from 'src/app/models/user.model';
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

  login(token: string) : Observable<User>{
    let header={'Authorization':'Basic '+token};
    return this.http.get<User>(environment.serverUrl + '/user/login', {headers:header })
  }
}
