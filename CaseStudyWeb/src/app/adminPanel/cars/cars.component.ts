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
    constructor(private adminService: AdminPanelService) {
        this.categories = constants.carCategories
        this.category = 'SUV'
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
    saveCarDetails():void {
        if (this.selectedAction === 'AddCars') {
            let obj = {
                'category': this.category,
                'brand': this.brand,
                'name': this.name
            }
            this.cars.push(obj)
        }
        this.adminService.saveCars(this.cars).subscribe(data => {
            this.cars = Object(data)
            this.category = ''
            this.brand = ''
            this.name = ''
        })
    }
}