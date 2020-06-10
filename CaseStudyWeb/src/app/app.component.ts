import { Component, DoCheck, OnDestroy } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: 'app.component.html',
    providers: [
    ]
})
export class AppComponent implements DoCheck, OnDestroy{
    localStorageValue:Object
    constructor(){
        this.localStorageValue = sessionStorage.getItem('currentUser')
    }
    ngOnDestroy(): void {
        sessionStorage.clear()
    }
    ngDoCheck(): void {
        this.localStorageValue = sessionStorage.getItem('currentUser')
    }
    clearLocalStorage():void {
        sessionStorage.removeItem('currentUser')
    } 
}

