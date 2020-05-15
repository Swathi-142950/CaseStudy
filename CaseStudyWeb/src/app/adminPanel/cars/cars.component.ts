import { Component, OnInit } from '@angular/core';
import { AdminPanelService } from '../admin.panel.service';
import * as _ from 'lodash';
import { constants } from 'src/app/constants';

@Component({
    templateUrl: 'cars.component.html',
    providers: [AdminPanelService]
})
export class CarsComponent implements OnInit{
    category:string
    name:string
    brand:string
    categories:Array<string>
    cars:Array<Object>
    editableCheck:boolean
    selectedAction:string
    deletedValues:Array<Object>
    constructor(private adminService: AdminPanelService) {
        this.categories = constants.carCategories
        this.category = 'SUV'
        this.deletedValues = []
    }
    ngOnInit(): void {
        let arr = []
        this.adminService.getCars().subscribe(data => {
            _.forEach(data, val => {
                arr.push(val)
            })
        })
        this.cars = arr
    }

    addRow() {
        let obj = {
            'category': this.category,
            'brand': this.brand,
            'name': this.name
        }
        this.cars.push(obj)
        this.category = ''
        this.brand = ''
        this.name = ''
    }

    deleteRow(index:number) {
        let splicedVal = this.cars.splice(index, 1)
        this.deletedValues.push(...splicedVal)
    }

    saveCarDetails():void {
        _.forEach(this.deletedValues, value => {
            value['deleteFlag'] = true
            this.cars.push(value)
        })
        this.adminService.saveCars(this.cars).subscribe(data => {
            this.cars = Object(data)
        })
    }
}