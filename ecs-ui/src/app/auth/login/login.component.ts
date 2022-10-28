import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl, Validators} from '@angular/forms';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  msg:string;
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email : new FormControl('',[Validators.required,Validators.email]),
     password : new FormControl('',[Validators.required, Validators.minLength(4)])
   });
  }

  onFormSubmit(){
      /* Read username/password and generate token */
      let token = window.btoa(this.loginForm.value.email + ':' + this.loginForm.value.password);
      this.authService.login(token);
    }

}
