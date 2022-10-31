import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { LoginComponent } from './auth/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { ManagerDashboardComponent } from './components/manager/manager-dashboard/manager-dashboard.component';
import { EmployeeDashboardComponent } from './components/employee/employee-dashboard/employee-dashboard.component';
import { InfoComponent } from './components/manager/info/info.component';
import { AccessComponent } from './components/manager/access/access.component';
import { LeaveComponent } from './components/manager/leave/leave.component';
import { ListComponent } from './components/manager/list/list.component'
@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    ManagerDashboardComponent,
    EmployeeDashboardComponent,
    InfoComponent,
    AccessComponent,
    LeaveComponent,
    ListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
