import { Component, Input, OnInit } from '@angular/core';
import { Employee } from 'src/models/Employee';

@Component({
  selector: 'app-employee-ops',
  templateUrl: './employee-ops.component.html',
  styleUrls: ['./employee-ops.component.css']
})
export class EmployeeOpsComponent implements OnInit {
  ename: string;
  ecity: string;

  @Input("employees")
  employees: Employee[]=[];
  tempEmployees: Employee[];

  constructor() { }

  ngOnInit(): void {
    this.tempEmployees = [...this.employees];
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
