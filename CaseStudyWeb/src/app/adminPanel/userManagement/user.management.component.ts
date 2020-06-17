import { Component, OnInit } from '@angular/core';
import { AdminPanelService } from '../admin.panel.service';
import * as _ from 'lodash';
import {saveAs} from 'file-saver'

@Component({
    templateUrl: 'user.management.component.html',
    providers: [AdminPanelService]
})
export class UserManagementComponent implements OnInit {
    users: Array<Object>
    washers: Array<Object>
    editableCheck: boolean
    selectedAction: string
    userValue: string
    deletedValues:Array<Object>
    constructor(private adminService: AdminPanelService) {
        this.deletedValues = []
    }

    ngOnInit(): void {
        let arr = []
        this.adminService.fetchUsers().subscribe(data => {
            this.users = _.filter(Object(data), {'role': 'customer'})
            this.washers = _.filter(Object(data), {'role': 'washer'})
        })
        this.userValue = 'userManagement'
    }

    invalidate (index:number) {
        if (this.users[index]['status'] === 'invalid') this.users[index]['status'] = 'valid'
        else this.users[index]['status'] = 'invalid'
    }

    invalidateWasher (index:number) {
        if (this.washers[index]['status'] === 'invalid') this.washers[index]['status'] = 'valid'
        else this.washers[index]['status'] = 'invalid'
    }

    saveUserData () {
        this.adminService.saveUserList(this.users).subscribe(data => {
            this.users = Object(data)
        })
    }

    saveWasherData () {
        this.adminService.saveWasherList(this.washers).subscribe(data => {
            this.washers = Object(data)
        })
    }

    generateWasherReport() {
        this.adminService.generateWasherReport().subscribe((data:Blob) => {
            const blobdownload = new Blob([data], { type: "application/xml.ms-excel;charset=utf-8" });
            saveAs(blobdownload, 'testdata.xls');
        })  
    }
}