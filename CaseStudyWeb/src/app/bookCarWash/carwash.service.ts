import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { constants } from '../constants';

@Injectable()
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
}