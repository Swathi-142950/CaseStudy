import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { SignupComponent } from "./signUp/signup.component";
import { CustomerComponent } from "./bookCarWash/customer.component";
import { CarwashComponent } from "./bookCarWash/carwash.component";
import { PaymentComponent } from "./payment/payment.component";
import { AdminPanelComponent } from "./adminPanel/admin.panel.component";
import {Routes} from '@angular/router'
import { adminRoute } from './adminPanel/admin.panel.route';

export const appRoutes:Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'customer/:id', component: CustomerComponent},
    {path: 'carwash', component: CarwashComponent},
    {path: 'payment', component: PaymentComponent},
    {path: 'admin', component: AdminPanelComponent, children: adminRoute},
    {path: '', redirectTo: 'home', pathMatch:'full'}
]