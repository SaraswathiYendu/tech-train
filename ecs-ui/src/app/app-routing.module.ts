import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { EleaveListComponent } from './components/employee/eleave-list/eleave-list.component';
import { EleaveComponent } from './components/employee/eleave/eleave.component';
import { EmployeeDashboardComponent } from './components/employee/employee-dashboard/employee-dashboard.component';
import { EprofileComponent } from './components/employee/eprofile/eprofile.component';
import { EticketListComponent } from './components/employee/eticket-list/eticket-list.component';
import { EticketComponent } from './components/employee/eticket/eticket.component';
import { AccessComponent } from './components/manager/access/access.component';
import { LeaveComponent } from './components/manager/leave/leave.component';
import { ListComponent } from './components/manager/list/list.component';
import { ManagerDashboardComponent } from './components/manager/manager-dashboard/manager-dashboard.component';
import { TicketListComponent } from './components/manager/ticket-list/ticket-list.component';

const routes: Routes = [
  {path: '' , redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'employee', component: EmployeeDashboardComponent ,
  children: [
      {path: '' , component: EprofileComponent},
      {path: 'ticket' , component: EticketComponent},
      {path: 'leave' , component: EleaveComponent},
      {path: 'ticket-list' , component: EticketListComponent},
      {path: 'leave-list' , component: EleaveListComponent}
  ]},
  {path: 'manager', component: ManagerDashboardComponent ,
  children:[
    {path: '', component: ListComponent},
    {path: 'access', component: AccessComponent},
    {path: 'tickets' , component: TicketListComponent},
    {path: 'leaves',component: LeaveComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
