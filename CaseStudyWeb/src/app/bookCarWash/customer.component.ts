import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Customer } from '../models/Customer';
import { Router, ActivatedRoute } from '@angular/router';
import { constants } from '../constants';
import { CarWashComponentService } from './carwash.service';

@Component({
    selector: 'customer-component',
    templateUrl: 'customer.component.html',
    providers:[CarWashComponentService]
})
export class CustomerComponent implements OnInit{
    customerForm:FormGroup
    customerObj:Customer
    serviceTimeOptions:Array<string>
    showFlag:string
    customerId:number
    constructor(private formBuilder: FormBuilder, private router:Router, private activatedRoute:ActivatedRoute, private carWashService:CarWashComponentService) {
    }
    ngOnInit(): void {
        this.customerId = Number(this.activatedRoute.snapshot.paramMap.get('id'))
        this.carWashService.fetchUserDetailsById(this.customerId).subscribe(data => {
            this.customerForm = this.formBuilder.group({
                customer_name: [data['fullname'], Validators.required],
                customer_phone: [data['phoneno'], Validators.required],
                customer_address: ['', Validators.required],
                customer_vehicle_number: ['', Validators.required],
                customer_service_date: ['', Validators.required],
                customer_service_time: ['']
            })
        })      
        this.serviceTimeOptions = constants.timeSlots
        this.showFlag = 'BookWash'
    }

    submitData () {
        this.router.navigate(['/carwash'])
    }
}