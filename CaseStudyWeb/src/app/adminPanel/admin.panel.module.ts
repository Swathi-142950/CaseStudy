import { NgModule } from '@angular/core';
import { AdminPanelRouteModule } from './admin.panel.route.module';
import { AddOnComponent } from './addOn/add.on.component';
import { ServiceComponent } from './service/service.component';
import { CarsComponent } from './cars/cars.component';

@NgModule({
    imports: [AdminPanelRouteModule],
    declarations: [AddOnComponent, ServiceComponent, CarsComponent],
    exports: [AdminPanelRouteModule]
})
export class AdminPanelModule{}