import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manager } from 'src/app/models/manager.model';
import { ManagerService } from 'src/app/services/manager.service';

@Component({
  selector: 'app-manager-dashboard',
  templateUrl: './manager-dashboard.component.html',
  styleUrls: ['./manager-dashboard.component.css']
})
export class ManagerDashboardComponent implements OnInit {
  manager: Manager;
  constructor(private managerService: ManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.managerService.getManagerInfo(localStorage.getItem('token'))
    .subscribe({
      next: (data)=>{
        this.manager = data;
        console.log(this.manager);
      },
      error:(error)=>{
          localStorage.removeItem('token');
          this.router.navigateByUrl("/login");
      },
      complete:()=>{}
    });
  }

}
