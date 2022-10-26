import { Component, OnInit } from '@angular/core';
import { RequestModel } from '../model/request.model';
import { RequestServiceService } from '../service/request-service.service';

@Component({
  selector: 'app-pending-request',
  templateUrl: './pending-request.component.html',
  styleUrls: ['./pending-request.component.css']
})
export class PendingRequestComponent implements OnInit {

  requestArry: RequestModel[]=[];

  constructor(private requestService: RequestServiceService) { }

  ngOnInit(): void {
    this.requestService.requests$.subscribe(data=>{
      this.requestArry = data;
    });
  }

}
