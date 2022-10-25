import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashboardComponent } from './admin-components/admindashboard/admindashboard.component';
 import { LoginComponent } from './auth/login/login.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { ContactComponent } from './components/contact/contact.component';
import { HealthComponent } from './components/health/health.component';
import { HomeComponent } from './components/home/home.component';
import { LifeComponent } from './components/life/life.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { VehicleComponent } from './components/vehicle/vehicle.component';
import { AuthGuardService } from './services/auth-guard.service';
import { DashboardComponent } from './vendor-components/dashboard/dashboard.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'health-insurance', component: HealthComponent},
  {path: 'life-insurance', component: LifeComponent},
  {path: 'vehical-insurance', component: VehicleComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'login', component: LoginComponent},
  {path: 'admin', component: AdmindashboardComponent,
                    canActivate: [AuthGuardService] },
  {path: 'vendor', component: DashboardComponent,
                    canActivate: [AuthGuardService] },
  {path: '**', component: PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
