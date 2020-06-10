import { Component, Input, OnInit } from '@angular/core';
import { CarWashComponentService } from '../carwash.service';

@Component({
    selector: 'payment-component',
    templateUrl: 'payment.component.html',
    providers: [CarWashComponentService]
})
export class PaymentComponent implements OnInit{
    customerDetails:any;
    carDetails:any;
    payments:Array<string>
    selectedPaymentMode:string
    generateReceipt:boolean
    washerDetails:Array<Object>
    constructor(private carwashService:CarWashComponentService){
        this.payments = ['COD', 'Credit Card', 'Debit Card', 'Net Banking', 'UPI']
        this.generateReceipt = false
        this.selectedPaymentMode = 'COD'
    }
    ngOnInit(): void {
        this.carDetails = JSON.parse(sessionStorage.getItem('carDetails'))
        this.carwashService.getWasherById(this.carDetails['washer']).subscribe(data => {
            this.washerDetails = Object(data)
        })
    }
    proceedToPayment():void {
        if (this.selectedPaymentMode === 'COD') {
            this.generateReceipt = true
            this.customerDetails = JSON.parse(sessionStorage.getItem('customerDetails'))
            this.carDetails = JSON.parse(sessionStorage.getItem('carDetails'))
            let finalCarDetails = this.carDetails['carData']
            let finalPackageDetails = this.carDetails['carWashPackage']
            let finalObj = {
                customerDetails: this.customerDetails,
                carDetails: finalCarDetails,
                payment: this.selectedPaymentMode,
                packageDetails: finalPackageDetails,
                washerDetails: this.washerDetails
            }
            this.carwashService.saveBookingDetails(finalObj).subscribe(data => {
                console.log(data)
            })
        } else {
            alert('Only COD available. Other payment methods are not available')
        }
    }
}