import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalcComponent } from './components/calc/calc.component';
import { ToggleComponent } from './components/toggle/toggle.component';
import { ArrayOpsComponent } from './components/array-ops/array-ops.component';
import { EmployeeOpsComponent } from './components/employee-ops/employee-ops.component';

@NgModule({
  declarations: [
    AppComponent,
    CalcComponent,
    ToggleComponent,
    ArrayOpsComponent,
    EmployeeOpsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
