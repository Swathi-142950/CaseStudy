import { NgModule } from '@angular/core';
import { AdminPanelRouteModule } from './admin.panel.route.module';
import { AddOnComponent } from './addOn/add.on.component';
import { ServiceComponent } from './service/service.component';
import { CarsComponent } from './cars/cars.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PromoComponent } from './promoCode/promo.component';

@NgModule({
    imports: [AdminPanelRouteModule, CommonModule, FormsModule],
    declarations: [AddOnComponent, ServiceComponent, CarsComponent, PromoComponent],
    exports: [AdminPanelRouteModule]
})
export class AdminPanelModule{}