import { Component } from '@angular/core';
import {DataService} from "./service/data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';


  appInfo = {
    groupId: '',
    artifactId: '',
    id: '',
    version: '',
    color: '',
    message: ''
  }
  constructor(private dataService:DataService) {
    dataService.getAppInfo().subscribe((response) => {
      this.appInfo = response;
      document.body.style.backgroundColor = this.appInfo.color;
    })
  }
}
