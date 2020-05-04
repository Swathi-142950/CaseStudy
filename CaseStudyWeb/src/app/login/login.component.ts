import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'login',
    templateUrl: 'login.component.html'
})
export class LoginComponent {
    loginOptions:Array<string>
    loginPerson:string
    proceed:boolean
    username:string
    password:string

    constructor(private router:Router) {
        this.loginOptions = ['Customer', 'Washer', 'Admin'],
        this.loginPerson = 'Admin'
        this.proceed = false
    }

    loginUser():void {
        if (this.username && this.password) {
            if (this.loginPerson === 'Customer') {
                this.router.navigate(['customer'])
            }
        }
    }
}