import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Customer } from '../models/customer.model';
import { Router, ActivatedRoute } from '@angular/router';
import { constants } from '../constants';
import { CarWashComponentService } from './carwash.service';

@Component({
    selector: 'customer-component',
    templateUrl: 'customer.component.html',
    providers:[CarWashComponentService]
})
export class CustomerComponent implements OnInit{
    @Output() customerDetails:EventEmitter<any> = new EventEmitter();
    customerForm:FormGroup
    customerEditForm:FormGroup
    customerObj:Customer
    serviceTimeOptions:Array<string>
    showFlag:string
    customerId:number
    savedDate:string
    toggleEdit:boolean
    constructor(private formBuilder: FormBuilder, private router:Router, private activatedRoute:ActivatedRoute, private carWashService:CarWashComponentService) {
        this.toggleEdit = false
    }
    ngOnInit(): void {
        this.customerForm = new FormGroup({
            id: new FormControl,
            customer_name: new FormControl,
            customer_phone: new FormControl,
            customer_address: new FormControl,
            customer_vehicle_number: new FormControl,
            customer_service_date: new FormControl,
            customer_service_time: new FormControl
        })
        this.customerEditForm = new FormGroup({
            fullname: new FormControl,
            phoneno: new FormControl,
            email: new FormControl
        })
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
            this.customerEditForm = this.formBuilder.group({
                fullname: [data['fullname']],
                phoneno: [data['phoneno']],
                email: [data['email']]
            })
        })
        this.carWashService.fetchCustomerDetailsById(this.customerId).subscribe(data => {
            if(data) {
                this.customerForm = this.formBuilder.group({
                    customer_name: [data['customer_name'], Validators.required],
                    customer_phone: [data['customer_phone'], Validators.required],
                    customer_address: [data['customer_address'], Validators.required],
                    customer_vehicle_number: [data['customer_vehicle_number'], Validators.required],
                    customer_service_date: [data['customer_service_date'], Validators.required],
                    customer_service_time: [data['customer_service_time']]
                })
                let newDate = new Date(data['customer_service_date'])
                this.savedDate = newDate.toDateString()
                localStorage.setItem('customerDetails', JSON.stringify(Object(data)))
            }
        })
        this.serviceTimeOptions = constants.timeSlots
        this.showFlag = 'BookWash'
    }

    submitData () {
        this.carWashService.saveCustomerDetails(this.customerForm.value, this.customerId).subscribe(() => {
            this.toggleEdit = false
            this.router.navigate(['/carwash'])
        })
    }

    updateUser () {
        this.carWashService.updateUserById(this.customerId, this.customerEditForm.value).subscribe(() => {
            alert('Data updated successfully')
        })
    }

    goToWashComponent () {
        this.router.navigate(['/carwash'])
    }
    
}