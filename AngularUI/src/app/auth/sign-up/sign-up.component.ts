import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { UserInfo } from 'src/models/UserInfo';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  loginForm: FormGroup;
  msg: string;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      name : new FormControl('',[Validators.required, Validators.pattern(/^[a-zA-Z ]+$/)]),
      email : new FormControl('',[Validators.required,Validators.email]),
      password : new FormControl('',[Validators.required, Validators.minLength(4)])
    });
  }

  onFormSubmit(){
      let userInfo: UserInfo ={
        name: this.loginForm.value.name,
        email: this.loginForm.value.email,
        password: this.loginForm.value.password
      };

      this.userService.signUp(userInfo).subscribe({
        next: (data)=>{
          //if api is successful, I will be here
          this.msg='SignUp Success!!';
        },
        error: (error)=>{
          //if api has errors, I will be here
          this.msg = 'Could not process operation, please Try again';
        }
      })
  }
}
