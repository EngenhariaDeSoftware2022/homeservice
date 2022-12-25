import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front';
  currentPage: string = "all-services"
  isUserLoggedIn: boolean = true

  @ViewChild('btn-container') input:any;

  toggleSelection(page: string) {
    this.currentPage = page;
  }
}
