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
  showAddress: boolean = false;
  lblButton:string = 'Show Address';
  calc(op:string){

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

  toggleAddress(){
    this.showAddress = !this.showAddress;
    if(this.showAddress == true)
        this.lblButton='Hide Address';
    else
        this.lblButton='Show Address';
  }
}
/*
  number: 10, 10.4
  string
  boolean
  any

  String Interpolation Operator: {{}}
*/
