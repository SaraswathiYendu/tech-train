import { Component, OnInit } from '@angular/core';
import { RequestModel } from '../model/request.model';
import { RequestServiceService } from '../service/request-service.service';

@Component({
  selector: 'app-suggestion',
  templateUrl: './suggestion.component.html',
  styleUrls: ['./suggestion.component.css']
})
export class SuggestionComponent implements OnInit {

  request1: RequestModel;
  request2: RequestModel;
  request3: RequestModel;
  requestArry: RequestModel[]=[];
  tempRequestArry: RequestModel[]=[];
  constructor(private requestService: RequestServiceService) { }

  ngOnInit(): void {
    this.request1 = {
      id: 1,
      name: 'harry potter',
      status: 'PENDING'
    };

    this.request2 = {
      id: 2,
      name: 'ronald weasley',
      status: 'PENDING'
    };

    this.request3 = {
      id: 3,
      name: 'hermione granger',
      status: 'PENDING'
    };

    this.requestArry.push(this.request1);
    this.requestArry.push(this.request2);
    this.requestArry.push(this.request3);

    this.tempRequestArry.push(this.request1);
    this.tempRequestArry.push(this.request2);
    this.tempRequestArry.push(this.request3);
  }

  onRequestClick(id:number){
       this.tempRequestArry = this.tempRequestArry
                              .filter(r=>r.id == id);

        this.requestArry = this.requestArry
                              .filter(r=>r.id != id);

        let temp  = this.requestService.requests$.getValue(); //[r1]
        temp.push(this.tempRequestArry[0]); //[r1,r2]

        this.requestService.requests$
                      .next(temp); //[r1,r2]

        this.tempRequestArry = this.requestArry;
  }
}
