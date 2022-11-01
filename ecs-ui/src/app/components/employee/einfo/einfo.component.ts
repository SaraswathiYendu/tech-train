import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee.model';

@Component({
  selector: 'app-einfo',
  templateUrl: './einfo.component.html',
  styleUrls: ['./einfo.component.css']
})
export class EinfoComponent implements OnInit {

  @Input("employee")
  employee: Employee;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.router.navigateByUrl('/login');
  }
}
