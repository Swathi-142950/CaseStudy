import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from './login.service';
import * as _ from 'lodash'

@Component({
    selector: 'login',
    templateUrl: 'login.component.html',
    providers:[LoginService]
})
export class LoginComponent {
    loginOptions:Array<string>
    loginPerson:string
    proceed:boolean
    username:string
    password:string

    constructor(private router:Router, private loginService: LoginService) {
        this.loginOptions = ['customer', 'washer', 'admin'],
        this.loginPerson = 'admin'
        this.proceed = false
    }

    loginUser():void {
        if (this.username && this.password) {
            this.loginService.fetchUserByRole(this.loginPerson).subscribe(data => {
                let found = _.find(data, {'username': this.username, 'password': this.password})
                if (found && this.loginPerson !== 'admin') {
                    this.router.navigate([`${this.loginPerson}/${found['id']}`])
                } else if (this.loginPerson === 'admin') {
                    this.router.navigate([`${this.loginPerson}`])
                } else {
                    alert('Please check your credentials again')
                }
            })
        }
    }
}