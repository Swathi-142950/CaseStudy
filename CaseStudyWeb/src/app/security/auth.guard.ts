import { CanActivate, ActivatedRouteSnapshot, RouterState, Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthGuard implements CanActivate {
    constructor (private router: Router) {
    }
    canActivate():boolean {
        if (sessionStorage.getItem('currentUser'))
        return true
        this.router.navigate(['login'])
        return false
    }
}