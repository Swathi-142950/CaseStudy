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
    deletedValues:Array<Object>
    constructor(private adminService: AdminPanelService) {
        this.deletedValues = []
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

    addRow() {
        let obj = {
            'addOnName': this.addOnName,
            'addOnCost': this.addOnCost
        }
        this.addOns.push(obj)
        this.addOnCost = null
        this.addOnName = ''
    }

    deleteRow(index:number) {
        let splicedVal = this.addOns.splice(index, 1)
        this.deletedValues.push(...splicedVal)
    }

    saveAddOnDetails(): void {
        _.forEach(this.deletedValues, value => {
            value['deleteFlag'] = true
            this.addOns.push(value)
        })
        this.adminService.saveAddOns(this.addOns).subscribe(data => {
            this.addOns = Object(data)
        })
    }
}