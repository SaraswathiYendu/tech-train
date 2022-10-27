import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators} from '@angular/forms';
@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signupForm: FormGroup;
  msg:string;
  constructor() { }

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      name : new FormControl('',[Validators.required, Validators.pattern(/^[a-zA-Z ]+$/)]),
      email : new FormControl('',[Validators.required,Validators.email]),
      password : new FormControl('',[Validators.required, Validators.minLength(4)]),
      jobTitle: new FormControl('', Validators.required),
      managerId: new FormControl('',Validators.required)
    });
  }

  onFormSubmit(){

  }

}
