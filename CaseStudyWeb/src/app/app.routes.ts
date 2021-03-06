import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { SignupComponent } from "./signUp/signup.component";
import { CustomerComponent } from "./bookCarWash/customer.component";
import { CarwashComponent } from "./bookCarWash/carwash.component";
import { PaymentComponent } from "./bookCarWash/payment/payment.component";
import { AdminPanelComponent } from "./adminPanel/admin.panel.component";
import {Routes} from '@angular/router'
import { adminRoute } from './adminPanel/admin.panel.route';
import { AuthGuard } from './security/auth.guard';
import { WasherComponent } from './washerPanel/washer.component';

export const appRoutes:Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'customer/:id', component: CustomerComponent, canActivate:[AuthGuard]},
    {path: 'washer/:id', component: WasherComponent, canActivate:[AuthGuard]},
    {path: 'carwash', component: CarwashComponent, canActivate:[AuthGuard]},
    {path: 'payment', component: PaymentComponent, canActivate:[AuthGuard]},
    {path: 'admin', component: AdminPanelComponent, children: adminRoute, canActivate:[AuthGuard]},
    {path: '', redirectTo: 'home', pathMatch:'full'},
    {path: '**', redirectTo: 'home', pathMatch:'full'}
]