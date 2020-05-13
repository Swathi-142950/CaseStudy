import { Component, OnInit } from '@angular/core';
import { AdminPanelService } from '../admin.panel.service';
import * as _ from 'lodash';

@Component({
    selector: 'service',
    templateUrl: 'service.component.html',
    providers: [AdminPanelService]
})
export class ServiceComponent implements OnInit {
    packageValue: string
    price: string
    services: Array<Object>
    editableCheck: boolean
    selectedAction: string
    constructor(private adminService: AdminPanelService) {
    }

    ngOnInit(): void {
        let arr = []
        this.adminService.getService().subscribe(data => {
            _.forEach(data, val => {
                arr.push(val)
            })
        })
        this.services = arr
    }

    saveServiceDetails(): void {
        if (this.selectedAction === 'AddService') {
            let obj = {
                'packageValue': this.packageValue,
                'price': this.price
            }
            this.services.push(obj)
        }
        this.adminService.saveServices(this.services).subscribe(data => {
            this.services = Object(data)
            this.packageValue = ''
            this.price = ''
        })
    }
}