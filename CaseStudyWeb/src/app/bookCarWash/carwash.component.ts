import { Component, OnInit } from '@angular/core';
import { CarDetails } from '../models/car.details.model'
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
    addData:Object
    addDataBrand:string
    addDataModel:string
    addDataType:string
    fullResponse:Array<Object>
    washerList:Array<Object>
    washer:string
    constructor (private carWashService:CarWashComponentService, private router: Router) {}

    ngOnInit() {
        this.carWashService.fetchCars().subscribe(data => {
            this.fullResponse = Object(data)
            this.carDetailsTableSUV = _.orderBy(_.filter(data, {'category': 'SUV'}), 'brand')
            this.carDetailsTableSedan = _.filter(data, {'category': 'Sedan'})
            this.carDetailsTableHB = _.filter(data, {'category': 'Hatchback'})
        })
        this.carWashService.fetchWashPackages().subscribe(data => {
            this.carWashData = Object(data)
        })
        this.typeFlag = 'SUV'
        this.carWashService.fetchWashers().subscribe(data => {
            this.washerList = Object(data)
        })
    }

    proceedToPayment() {
        if (this.carWashPackage && (this.suvData || this.sedanData || this.hbData || (this.addDataBrand && this.addDataModel && this.addDataType)) && this.washer) {
            let carDataObj = []
            let finalObj = {
                brand: '',
                category: '',
                name: ''
            }
            let carDataVal:any
            carDataObj.push(this.suvData)
            carDataObj.push(this.sedanData)
            carDataObj.push(this.hbData)
            if (this.addDataBrand && this.addDataModel && this.addDataType) {
                finalObj = {
                    brand: this.addDataBrand,
                    category: this.addDataType,
                    name: this.addDataModel
                }
                carDataVal = finalObj
            }
            _.forEach(carDataObj, val => {
                if (val) {
                    carDataVal = _.find(this.fullResponse, {'name': val})
                }
            })
            let obj = {
                carWashPackage: this.carWashPackage,
                carData: carDataVal,
                washer: this.washer
            }
            localStorage.setItem('carDetails', JSON.stringify(obj))
            this.router.navigate(['/payment'])
        } else {
            alert('Please select package and car to proceed')
        }
    }
}