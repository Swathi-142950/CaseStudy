import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { constants } from '../constants';

@Injectable()
export class LoginService {
    constructor(private httpClient:HttpClient) {}

    fetchUserByRole(role:string) {
        return this.httpClient.get(constants.baseUrl + `/users/loginByRole/${role}`)
    }
}