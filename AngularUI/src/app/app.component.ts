import { Component } from '@angular/core';
import { Employee } from 'src/models/Employee';

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
  ename: string;
  ecity: string;

  e1:Employee={
    id:1,
    name: 'harry potter',
    salary: 85000,
    city: 'london'
  };

  e2: Employee={
    id:2,
    name: 'ronald weasley',
    salary: 75000,
    city: 'surrey'
  };

  e3: Employee={
    id:3,
    name: 'hermione granger',
    salary: 95000,
    city: 'london'
  };

  /* Create an Array of Employee and push the objects in the array */
  employees: Employee[]= [this.e1,this.e2,this.e3];
  tempEmployees: Employee[]= [this.e1,this.e2,this.e3];
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

  search(criteria:string){
    if(this.ename == '')
        this.employees = this.tempEmployees;
    else
    switch(criteria){
      case 'name':
        this.employees = this.tempEmployees;
        this.employees = this.employees.filter(e=>e.name === this.ename);
        break;
      case 'city':
        if(this.ecity == '' || this.ecity == undefined){
          this.employees = this.tempEmployees;
        }
        else{
          this.employees = this.tempEmployees;
          this.employees = this.employees.filter(e=>e.city === this.ecity);
        }
        break;
      default:
       this.employees = this.tempEmployees;

    }
  }

  sortEmployees(sortDirection: string){
    this.employees = this.tempEmployees;
    switch(sortDirection){
      case 'ASC':
        this.employees = this.employees.sort((e1, e2) => e1.salary - e2.salary);
        break;
      case 'DESC':
        this.employees = this.employees.sort((e1, e2) => e2.salary - e1.salary);
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
