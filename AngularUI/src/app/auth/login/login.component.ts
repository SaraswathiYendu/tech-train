import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { UserInfo } from 'src/models/UserInfo';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  msg: string;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
       email : new FormControl('',[Validators.required,Validators.email]),
      password : new FormControl('',[Validators.required, Validators.minLength(4)])
    });
  }

  onFormSubmit(){
    let userInfo: UserInfo ={
      email: this.loginForm.value.email,
      password: this.loginForm.value.password
    };

    console.log(userInfo);
    this.userService.login(userInfo).subscribe({
      next:  (data)=>{
          console.log('login success');

       },
      error: (error)=>{
          console.log(error);
      }
    });
  }


}
