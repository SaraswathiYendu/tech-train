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
  nums:number[]=[4,2,7,1,6,9,8,3];
  numsTemp: number[] =[4,2,7,1,6,9,8,3];
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

  filterArray(op){
    switch(op){
      case 'even':
        this.nums = this.numsTemp;
        this.nums = this.nums.filter(n=>n%2==0);
        break;
      case 'odd':
        this.nums = this.numsTemp;
        this.nums = this.nums.filter(n=>n%2==1);
        break;
      case 'reset':
        this.nums = this.numsTemp;
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
