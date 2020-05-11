import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { adminRoute } from './admin.panel.route';

@NgModule({
    imports:[RouterModule.forRoot(adminRoute)],
    declarations: [],
    exports:[RouterModule]
})
export class AdminPanelRouteModule{}