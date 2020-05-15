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
    deletedValues:Array<Object>
    constructor(private adminService: AdminPanelService) {
        this.deletedValues = []
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

    addRow() {
        let obj = {
            'packageValue': this.packageValue,
            'price': this.price
        }
        this.services.push(obj)
        this.packageValue = ''
        this.price = ''
    }

    deleteRow(index:number) {
        let splicedVal = this.services.splice(index, 1)
        this.deletedValues.push(...splicedVal)
    }

    saveServiceDetails(): void {
        _.forEach(this.deletedValues, value => {
            value['deleteFlag'] = true
            this.services.push(value)
        })
        this.adminService.saveServices(this.services).subscribe(data => {
            this.services = Object(data)
        })
    }
}