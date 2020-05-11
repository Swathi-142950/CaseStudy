import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SignUpService } from './signup.service';

@Component({
    selector: 'signup',
    templateUrl: 'signup.component.html',
    providers: [SignUpService]
})
export class SignupComponent {
    email:string
    password:string
    username:string
    fullname:string
    phoneno:string

    constructor(private router:Router, private signUpService:SignUpService) {
    }

    checkValidation(value, str:string) {
        let flag:boolean
        if (str === 'fullname') flag = /[A-Za-z]{3}[A-Za-z ]+/.test(value)
        return flag
    }

    signUp():void {
        if (this.email && this.password && this.username) {
            let obj = {
                'email': this.email,
                'password': this.password,
                'username': this.username,
                'fullname': this.fullname,
                'phoneno': this.phoneno,
                'role': 'customer'
            }
            this.signUpService.saveUsers(obj).subscribe(data => {
                this.router.navigate(['/login'])
            })
        } else {
            alert('Please enter all the required details')
        }
    }
}