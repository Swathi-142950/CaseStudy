import { Component } from '@angular/core';

@Component({
    selector: 'payment-component',
    templateUrl: 'payment.component.html'
})
export class PaymentComponent {
    payments:Array<string>
    selectedPaymentMode:string
    generateReceipt:boolean
    constructor(){
        this.payments = ['COD', 'Credit Card', 'Debit Card', 'Net Banking', 'UPI']
        this.generateReceipt = false
        this.selectedPaymentMode = 'COD'
    }
    proceedToPayment():void {
        if (this.selectedPaymentMode === 'COD') {
            this.generateReceipt = true
        } else {
            alert('Only COD available. Other payment methods are not available')
        }
    }
}