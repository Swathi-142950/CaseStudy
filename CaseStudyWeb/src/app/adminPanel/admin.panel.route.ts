import { Routes } from '@angular/router';
import { AddOnComponent } from './addOn/add.on.component';
import { ServiceComponent } from './service/service.component';
import { CarsComponent } from './cars/cars.component';

export const adminRoute:Routes = [
    {path: '', redirectTo: 'addon', pathMatch: 'full'},
    {path: 'addon', component: AddOnComponent},
    {path: 'service', component: ServiceComponent},
    {path: 'cars', component: CarsComponent}
]