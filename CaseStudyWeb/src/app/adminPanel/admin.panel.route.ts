import { Routes } from '@angular/router';
import { AddOnComponent } from './addOn/add.on.component';
import { ServiceComponent } from './service/service.component';
import { CarsComponent } from './cars/cars.component';
import { PromoComponent } from './promoCode/promo.component';
import { AuthGuard } from '../security/auth.guard';

export const adminRoute:Routes = [
    {path: 'addon', component: AddOnComponent, canActivate:[AuthGuard]},
    {path: 'service', component: ServiceComponent, canActivate:[AuthGuard]},
    {path: 'cars', component: CarsComponent, canActivate:[AuthGuard]},
    {path: 'promo', component: PromoComponent, canActivate:[AuthGuard]}
]