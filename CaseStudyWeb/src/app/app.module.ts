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
import { PaymentComponent } from './payment/payment.component'

@NgModule({
    imports: [BrowserModule, FormsModule,ReactiveFormsModule, RouterModule.forRoot([
        {path: 'home', component: HomeComponent},
        {path: 'login', component: LoginComponent},
        {path: 'signup', component: SignupComponent},
        {path: 'customer', component: CustomerComponent},
        {path: 'carwash', component: CarwashComponent},
        {path: 'payment', component: PaymentComponent},
        {path: '', redirectTo: 'home', pathMatch:'full'}
    ]),RouterModule.forChild([
        {path: 'aboutUs', component: AboutUsComponent, outlet: 'secondary'}
    ]),HttpClientModule],
    declarations: [AppComponent, HomeComponent, AboutUsComponent, PaymentComponent, CarwashComponent, CustomerComponent, LoginComponent, SignupComponent],
    bootstrap: [AppComponent]
})
export class AppModule { }
