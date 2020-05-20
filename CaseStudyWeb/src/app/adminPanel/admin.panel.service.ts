import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { constants } from '../constants';

@Injectable()
export class AdminPanelService {
    constructor(private httpClient:HttpClient) {}

    saveServices(obj:Object) {
        let url = constants.baseUrl + `/wash/saveWashPackages`
        return this.httpClient.post(url, obj)
    }

    getService() {
        return this.httpClient.get(constants.baseUrl + `/wash/fetchWashPackages`)
    }

    getCars () {
        return this.httpClient.get(constants.baseUrl + `/cars/fetchCars`)
    }

    saveCars(obj:Object) {
        let url = constants.baseUrl + `/cars/saveCars`
        return this.httpClient.post(url, obj)
    }

    getAddOns() {
        return this.httpClient.get(constants.baseUrl + `/addons/fetchAddOns`)
    }

    saveAddOns(obj:Object) {
        let url = constants.baseUrl + `/addons/saveAddOns`
        return this.httpClient.post(url, obj)
    }

    getPromos () {
        return this.httpClient.get(constants.baseUrl + `/promo/fetchPromo`)
    }

    savePromos(obj:Object) {
        let url = constants.baseUrl +  `/promo/savePromo`
        return this.httpClient.post(url, obj)
    }
}