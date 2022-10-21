import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo } from 'src/models/UserInfo';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  //post(url,object)
  public signUp(userInfo: UserInfo) : Observable<any>{
      let obj={
        name:userInfo.name,
        city:"chennai",
        user: {
            username: userInfo.email,
            password: userInfo.password
        }
    }
      return this.http.post('http://localhost:8585/customer/add', obj);
  }
}
