import { Component, OnInit } from '@angular/core';
import { CarDetails } from '../models/CarDetails'
import { CarWashComponentService } from './carwash.service'
import * as _ from 'lodash'
import { Router } from '@angular/router';

@Component({
    selector: 'carwash-component',
    templateUrl: 'carwash.component.html',
    providers: [CarWashComponentService]
})
export class CarwashComponent{
    carDetails:CarDetails
    carDetailsTableSUV:Array<Object>
    carDetailsTableSedan:Array<Object>
    carDetailsTableHB:Array<Object>
    selectedIndexVal:number
    typeFlag:string
    carWashData:Array<Object>
    suvData:string
    sedanData:string
    hbData:string
    carWashPackage:string
    constructor (private carWashService:CarWashComponentService, private router: Router) {}

    ngOnInit() {
        this.carWashService.fetchCars().subscribe(data => {
            this.carDetailsTableSUV = _.orderBy(_.filter(data, {'category': 'SUV'}), 'brand')
            this.carDetailsTableSedan = _.filter(data, {'category': 'Sedan'})
            this.carDetailsTableHB = _.filter(data, {'category': 'Hatchback'})
        })
        this.carWashService.fetchWashPackages().subscribe(data => {
            this.carWashData = Object(data)
        })
        this.typeFlag = 'SUV'
    }

    proceedToPayment() {
        if (this.carWashPackage && (this.suvData || this.sedanData || this.hbData)) {
            this.router.navigate(['/payment'])
        } else {
            alert('Please select package and car to proceed')
        }
    }
}