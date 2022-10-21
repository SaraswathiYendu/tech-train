import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignUpComponent } from './auth/sign-up/sign-up.component';
import { ContactComponent } from './components/contact/contact.component';
import { HealthComponent } from './components/health/health.component';
import { HomeComponent } from './components/home/home.component';
import { LifeComponent } from './components/life/life.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { VehicleComponent } from './components/vehicle/vehicle.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'health-insurance', component: HealthComponent},
  {path: 'life-insurance', component: LifeComponent},
  {path: 'vehical-insurance', component: VehicleComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'login', component: LoginComponent},
  {path: '**', component: PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
