import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { RequestModel } from '../model/request.model';

@Injectable({
  providedIn: 'root'
})
export class RequestServiceService {

  requests$ = new BehaviorSubject<RequestModel[]>([]);
  constructor() { }
}
