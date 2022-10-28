import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
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

}
