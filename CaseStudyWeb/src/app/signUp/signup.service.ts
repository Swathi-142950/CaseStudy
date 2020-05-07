import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { constants } from '../constants';
import { User } from '../models/User';

@Injectable()
export class SignUpService {
    constructor(private httpClient:HttpClient) {}
    
    fetchUsers() {
        return this.httpClient.get(constants.baseUrl + '/users/fetchUsers')
    }

    saveUsers (userDetails:User) {
        let url = constants.baseUrl + '/users/saveUser'
        return this.httpClient.post<User>(url, userDetails, {
            headers: new HttpHeaders({
                'Content-type': 'application/json'
            })
        })
    }
}