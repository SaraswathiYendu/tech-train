import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalcComponent } from './components/calc/calc.component';
import { ToggleComponent } from './components/toggle/toggle.component';
import { ArrayOpsComponent } from './components/array-ops/array-ops.component';
import { EmployeeOpsComponent } from './components/employee-ops/employee-ops.component';
import { PostComponent } from './components/post/post.component';
import { TodoComponent } from './components/todo/todo.component';
import { CustomerComponent } from './components/customer/customer.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { HealthComponent } from './components/health/health.component';
import { LifeComponent } from './components/life/life.component';
import { VehicleComponent } from './components/vehicle/vehicle.component';
import { ContactComponent } from './components/contact/contact.component';
import { LoginComponent } from './auth/login/login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    CalcComponent,
    ToggleComponent,
    ArrayOpsComponent,
    EmployeeOpsComponent,
    PostComponent,
    TodoComponent,
    CustomerComponent,
    SignUpComponent,
    NavbarComponent,
    HomeComponent,
    HealthComponent,
    LifeComponent,
    VehicleComponent,
    ContactComponent,
    LoginComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
