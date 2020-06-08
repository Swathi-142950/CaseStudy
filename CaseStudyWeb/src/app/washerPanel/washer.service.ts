import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class WasherService {
    constructor(private httpClient:HttpClient) {}

    fetchWashers() {
    }
}