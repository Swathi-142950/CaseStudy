import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { constants } from '../constants';
import { User } from '../models/user.model';
import { Customer } from '../models/customer.model';

@Injectable({providedIn: 'root'})
export class CarWashComponentService {
    constructor(private httpClient:HttpClient) {}

    fetchCars() {
        return this.httpClient.get(constants.baseUrl + '/cars/fetchCars')
    }

    fetchWashPackages () {
        return this.httpClient.get(constants.baseUrl + '/wash/fetchWashPackages')
    }

    fetchUserDetailsById (id:number) {
        return this.httpClient.get(constants.baseUrl + `/users/fetchUserById/${id}`)
    }

    updateUserById (id:number, userDetails:User) {
        let url = constants.baseUrl + `/users/updateUser/${id}`
        return this.httpClient.put(url, userDetails)
    }

    saveCustomerDetails (customerDetails:Customer, customerId:number) {
        let url = constants.baseUrl + `/customers/saveCustomerDetails/${customerId}`
        return this.httpClient.post(url, customerDetails)
    }

    fetchCustomerDetailsById(customerId:number) {
        let url = constants.baseUrl + `/customers/getCustomerDetails/${customerId}`
        return this.httpClient.get(url)
    }

    saveBookingDetails(bookingDetails:Object) {
        let url = constants.baseUrl + `/booking/saveBookingDetails`
        return this.httpClient.post(url, bookingDetails);
    }

    fetchWashers() {
        let url = constants.baseUrl + `/users/washer/getWasher`
        return this.httpClient.get(url)
    }

    getWasherById(id:number) {
        let url = constants.baseUrl + `/users/washer/getWasherById/${id}`
        return this.httpClient.get(url)
    }
}