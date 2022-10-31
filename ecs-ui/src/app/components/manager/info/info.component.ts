import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manager } from 'src/app/models/manager.model';

@Component({
  selector: 'app-manager-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  @Input("manager")
  manager : Manager;

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  logout(){
    //delete the token from local storage
    localStorage.removeItem('token');
    this.router.navigateByUrl('/login');
  }
}
