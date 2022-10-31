import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  msg:string;
  user: User;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email : new FormControl('',[Validators.required,Validators.email]),
     password : new FormControl('',[Validators.required, Validators.minLength(4)])
   });
  }

  onFormSubmit(){
      /* Read username/password and generate token */
      let token = window.btoa(this.loginForm.value.email + ':' + this.loginForm.value.password);
      this.authService.login(token).subscribe({
        next: (data)=>{
            this.user = data;
            localStorage.setItem('token',token );
            switch(this.user.role){
                case 'EMPLOYEE':
                  break;
                case 'MANAGER':
                  /* Transfer to Manager Dashboard*/
                  this.router.navigateByUrl('/manager');
                  break;
                default:
                  break;
            }
        },
        error: (error)=>{
          if(error.status === 403)
          {
            this.msg = error.error.msg;
          }
          else
            this.msg="Invalid Credentials";
        }
      });
    }

}
