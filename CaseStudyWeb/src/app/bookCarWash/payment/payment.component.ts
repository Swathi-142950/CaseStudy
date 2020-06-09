import { Component, Input } from '@angular/core';
import { CarWashComponentService } from '../carwash.service';

@Component({
    selector: 'payment-component',
    templateUrl: 'payment.component.html',
    providers: [CarWashComponentService]
})
export class PaymentComponent {
    customerDetails:any;
    carDetails:any;
    payments:Array<string>
    selectedPaymentMode:string
    generateReceipt:boolean
    constructor(private carwashService:CarWashComponentService){
        this.payments = ['COD', 'Credit Card', 'Debit Card', 'Net Banking', 'UPI']
        this.generateReceipt = false
        this.selectedPaymentMode = 'COD'
    }
    proceedToPayment():void {
        if (this.selectedPaymentMode === 'COD') {
            this.generateReceipt = true
            this.customerDetails = JSON.parse(localStorage.getItem('customerDetails'))
            this.carDetails = JSON.parse(localStorage.getItem('carDetails'))
            let finalObj = {}
            this.carwashService.saveBookingDetails(finalObj).subscribe(data => {
                console.log(data)
            })
        } else {
            alert('Only COD available. Other payment methods are not available')
        }
    }
}