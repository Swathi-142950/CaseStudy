import { Component, OnInit } from '@angular/core';
import { AdminPanelService } from '../admin.panel.service';
import * as _ from 'lodash';
@Component({
    templateUrl: 'promo.component.html',
    providers: [AdminPanelService]
})
export class PromoComponent implements OnInit {
    description:string
    promoCode:string
    promos:Array<Object>
    selectedAction: string
    deletedValues:Array<Object>
    constructor(private adminService: AdminPanelService) {
        this.deletedValues = []
    }

    ngOnInit(): void {
        let arr = []
        this.adminService.getPromos().subscribe(data => {
            _.forEach(data, val => {
                arr.push(val)
            })
        })
        this.promos = arr
    }

    addRow() {
        let obj = {
            'promoCode': this.promoCode,
            'description': this.description
        }
        this.promos.push(obj)
        this.description = ''
    }

    deleteRow(index:number) {
        let splicedVal = this.promos.splice(index, 1)
        this.deletedValues.push(...splicedVal)
    }

    savePromoDetails(): void {
        _.forEach(this.deletedValues, value => {
            value['deleteFlag'] = true
            this.promos.push(value)
        })
        this.adminService.savePromos(this.promos).subscribe(data => {
            this.promos = Object(data)
        })
    }
}