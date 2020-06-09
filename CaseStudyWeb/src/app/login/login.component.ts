import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from './login.service';
import * as _ from 'lodash'
import { Socialusers } from '../models/social.users.model';
import { AuthServiceConfig, SocialLoginModule, AuthService, FacebookLoginProvider } from 'angularx-social-login'
import { SocialloginService } from '../security/social.login.service';

@Component({
    selector: 'login',
    templateUrl: 'login.component.html',
    providers: [LoginService]
})
export class LoginComponent {
    response;
    socialusers = new Socialusers();
    loginOptions: Array<string>
    loginPerson: string
    proceed: boolean
    username: string
    password: string

    constructor(private router: Router, private loginService: LoginService, public OAuth: AuthService,
        private SocialloginService: SocialloginService) {
        this.loginOptions = ['customer', 'washer', 'admin'],
        this.loginPerson = 'admin'
        this.proceed = false
    }

    loginUser(): void {
        if (this.username && this.password) {
            this.loginService.fetchUserByRole(this.loginPerson).subscribe(data => {
                let found = _.find(data, { 'username': this.username, 'password': this.password })
                if (found && found['status'] === 'valid') {
                    if (found && this.loginPerson !== 'admin') {
                        this.router.navigate([`${this.loginPerson}/${found['id']}`])
                    } else if (found && this.loginPerson === 'admin') {
                        this.router.navigate([`${this.loginPerson}`])
                    } else {
                        alert('Please check your credentials again')
                    }
                    localStorage.setItem('currentUser', JSON.stringify(found));
                } else if (found && found['status'] === 'invalid') {
                    alert('You account has been deactivated!! Please contact the customer care to know the reason and to activate!!')
                } else {
                    alert('Please check your credentials again')
                }
            })
        }
    }
    public socialSignIn(socialProvider: string) {
        let socialPlatformProvider;
        if (socialProvider === 'facebook') {
            socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
        }
        this.OAuth.signIn(socialPlatformProvider).then(socialusers => {
            console.log(socialProvider, socialusers);
            console.log(socialusers);
            this.Savesresponse(socialusers);
        });
    }
    Savesresponse(socialusers: Socialusers) {
        this.SocialloginService.savefbresponse(socialusers).subscribe((res: any) => {
            debugger;
            console.log(res);
            this.socialusers = res;
            this.response = res.userDetail;
            localStorage.setItem('socialusers', JSON.stringify(this.socialusers));
            this.router.navigate([`/Dashboard`]);
        })
    }
}