import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser'
import { AppComponent } from './app.component';
import { CustomerComponent } from './bookCarWash/customer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router'
import { AboutUsComponent } from './aboutUs/about.us.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signUp/signup.component';
import { CarwashComponent } from './bookCarWash/carwash.component';
import { PaymentComponent } from './payment/payment.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule, MatInputModule, MatNativeDateModule } from '@angular/material';
import { AdminPanelComponent } from './adminPanel/admin.panel.component';
import { AppRouteModule } from './app.route.module';
import { AdminPanelModule } from './adminPanel/admin.panel.module';
import { AuthGuard } from './security/auth.guard';

@NgModule({
    imports: [BrowserModule, FormsModule, MatDatepickerModule, MatInputModule, AdminPanelModule, MatNativeDateModule, ReactiveFormsModule, AppRouteModule, RouterModule.forChild([
        {path: 'aboutUs', component: AboutUsComponent, outlet: 'secondary'}
    ]),HttpClientModule, BrowserAnimationsModule],
    declarations: [AppComponent,
        HomeComponent,
        AdminPanelComponent,
        AboutUsComponent,
        PaymentComponent, 
        CarwashComponent, 
        CustomerComponent, 
        LoginComponent,
        SignupComponent],
    bootstrap: [AppComponent],
    providers:[AuthGuard]
})
export class AppModule { }
