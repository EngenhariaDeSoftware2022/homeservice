import { Component, ViewChild } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front';
  currentPage: string = "about"
  isUserLoggedIn: boolean = true

  @ViewChild('btn-container') input:any;

  constructor(private authService: AuthService) {

  }

  ngOnInit() {

  }

  toggleSelection(page: string) {
    this.currentPage = page;
  }

  logout() {
    this.authService.logout()
    this.isUserLoggedIn = false
  }
}
