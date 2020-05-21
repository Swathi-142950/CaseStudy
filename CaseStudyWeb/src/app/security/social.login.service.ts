import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { constants } from '../constants';
@Injectable({
    providedIn: 'root'
})
export class SocialloginService {
    url: string;
    constructor(private http: HttpClient) { }
    savefbresponse(response:object) {
        this.url = constants.baseUrl + `/login/savefbresponse`
        return this.http.post(this.url, response);
    }
}