import { Component } from '@angular/core';

@Component({ //<-- decorator
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  x:number=20;
  y:number=10;
  result:number;

  calc(op:string){
    console.log('calc called... ' + op);
    switch(op){
      case 'add':
        this.result = this.x + this.y;
        break;
      case 'sub':
        this.result = this.x - this.y;
        break;
      case 'mul':
        this.result = this.x * this.y;
        break;
      case 'div':
        this.result = this.x / this.y;
        break;
    }
  }
}
/*
  number: 10, 10.4
  string
  boolean
  any

  String Interpolation Operator: {{}}
*/
