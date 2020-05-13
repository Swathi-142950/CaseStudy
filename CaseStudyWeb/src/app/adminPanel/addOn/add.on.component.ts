import { Component, OnInit } from '@angular/core';
import { AdminPanelService } from '../admin.panel.service';
import * as _ from 'lodash';
@Component({
    templateUrl: 'add.on.component.html',
    providers: [AdminPanelService]
})
export class AddOnComponent implements OnInit {
    addOnName: string
    addOnCost: string
    addOns: Array<Object>
    editableCheck: boolean
    selectedAction: string
    constructor(private adminService: AdminPanelService) {
    }

    ngOnInit(): void {
        let arr = []
        this.adminService.getAddOns().subscribe(data => {
            _.forEach(data, val => {
                arr.push(val)
            })
        })
        this.addOns = arr
    }

    saveAddOnDetails(): void {
        if (this.selectedAction === 'AddAddOn') {
            let obj = {
                'addOnName': this.addOnName,
                'addOnCost': this.addOnCost
            }
            this.addOns.push(obj)
        }
        this.adminService.saveAddOns(this.addOns).subscribe(data => {
            this.addOns = Object(data)
            this.addOnCost = null
            this.addOnName = ''
        })
    }
}