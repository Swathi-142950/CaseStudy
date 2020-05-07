import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Customer } from '../models/Customer';
import { Router } from '@angular/router';
import { constants } from '../constants';

@Component({
    selector: 'customer-component',
    templateUrl: 'customer.component.html'
})
export class CustomerComponent implements OnInit{
    customerForm:FormGroup
    customerObj:Customer
    serviceTimeOptions:Array<string>
    constructor(private formBuilder: FormBuilder, private router:Router) {
    }
    ngOnInit(): void {
        this.serviceTimeOptions = constants.timeSlots
        this.customerForm = this.formBuilder.group({
            customer_name: ['', Validators.required],
            customer_phone: ['', Validators.required],
            customer_address: ['', Validators.required],
            customer_vehicle_number: ['', Validators.required],
            customer_service_date: [''],
            customer_service_time: ['']
        })
    }

    submitData () {
        this.router.navigate(['/carwash'])
    }
}