import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators} from '@angular/forms';
import { Employee } from 'src/app/models/employee.model';
import { Manager } from 'src/app/models/manager.model';
import { EmployeeService } from 'src/app/services/employee.service';
import { ManagerService } from 'src/app/services/manager.service';
import { AuthService } from '../service/auth.service';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signupForm: FormGroup;
  msg:string;
  managerArry: Manager[];
  employee: Employee;
  signupSuccess: boolean = false;

  constructor(private managerService: ManagerService,
    private employeeService: EmployeeService ,
    private authService : AuthService) { }

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      name : new FormControl('',[Validators.required, Validators.pattern(/^[a-zA-Z ]+$/)]),
      email : new FormControl('',[Validators.required,Validators.email]),
      password : new FormControl('',[Validators.required, Validators.minLength(4)]),
      jobTitle: new FormControl('', Validators.required),
      managerId: new FormControl('',Validators.required)
    });

    /* Call the API and fetch all manager details */
    this.managerService.fetchAllManagers().subscribe({
      next: (data)=>{
        this.managerArry = data;
       },
      error: ()=>{ }
    });
  }

  onFormSubmit(){
      /* CALL THE API to post employee details */
      this.employee = {
        name: this.signupForm.value.name,
        username: this.signupForm.value.email,
        password: this.signupForm.value.password,
        jobTitle: this.signupForm.value.jobTitle
      };

      this.authService.postEmployee(this.employee,this.signupForm.value.managerId)
      .subscribe({
        next: (data)=>{
           this.msg='Signup Success';
           this.signupSuccess = true;
        },
        error: (error)=>{
          this.msg=error.msg;
        }
      });
  }

}
