import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Customer } from '../models/Customer';
import { Router } from '@angular/router';

@Component({
    selector: 'customer-component',
    templateUrl: 'customer.component.html'
})
export class CustomerComponent implements OnInit{
    customerForm:FormGroup
    customerObj:Customer
    constructor(private formBuilder: FormBuilder, private router:Router) {
    }
    ngOnInit(): void {
        this.customerForm = new FormGroup({
            id: new FormControl,
            customer_name: new FormControl,
            customer_phone: new FormControl,
            customer_address: new FormControl,
            customer_vehicle_number: new FormControl
        })
        this.customerForm = this.formBuilder.group({
            customer_name: ['', Validators.required],
            customer_phone: ['', Validators.required],
            customer_address: ['', [Validators.required, Validators.min(20), Validators.max(55)]],
            customer_vehicle_number: ['', Validators.required]
        })
    }

    submitData () {
        this.router.navigate(['/carwash'])
    }
}