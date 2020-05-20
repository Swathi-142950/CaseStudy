import { Component, OnInit, OnChanges, DoCheck } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: 'app.component.html',
    providers: [
    ]
})
export class AppComponent implements DoCheck{
    localStorageValue:Object
    constructor(){
        this.localStorageValue = localStorage.getItem('currentUser')
    }
    ngDoCheck(): void {
        this.localStorageValue = localStorage.getItem('currentUser')
    }
    clearLocalStorage():void {
        localStorage.removeItem('currentUser')
    } 
}

