import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Employee } from 'src/app/models/employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-eprofile',
  templateUrl: './eprofile.component.html',
  styleUrls: ['./eprofile.component.css']
})
export class EprofileComponent implements OnInit {

  profileForm: FormGroup;
  employee: Employee;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getUser(localStorage.getItem('token'))
    .subscribe({
      next: (data)=>{
        this.employee = data;
        this.profileForm = new FormGroup({
          name: new FormControl(this.employee.name),
          email: new FormControl(this.employee.username),
          jobTitle: new FormControl(this.employee.jobTitle),
          managerName : new FormControl(this.employee.managerName)
        });
      }
    });

    this.profileForm = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      jobTitle: new FormControl(''),
      managerName : new FormControl('')
    });
  }

  onSubmit(){
      console.log(this.profileForm.value);
  }
}
