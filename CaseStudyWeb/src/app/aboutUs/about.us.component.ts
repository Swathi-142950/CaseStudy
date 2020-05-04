import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    templateUrl: 'about.us.component.html'
})
export class AboutUsComponent {
    constructor(private router: Router, private activatedRoute: ActivatedRoute) { }
    closeSecondaryRoute() {
        this.router.navigate(
            [
                "../",
                {
                    outlets: {
                        secondary: null
                    }
                }
            ]
        )
    }
}