import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AllServicesComponent } from './all-services/all-services.component';
import { MyServicesComponent } from './my-services/my-services.component';
import { NewServiceComponent } from './new-service/new-service.component';
import { DetailedServiceComponent } from './detailed-service/detailed-service.component';
import { AboutComponent } from './about/about.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { LoginComponent } from './login/login.component';


import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatSelectModule } from '@angular/material/select';
import { OfereceServicoComponent } from './oferece-servico/oferece-servico.component';
import { TelaServicoComponent } from './tela-servico/tela-servico.component';



@NgModule({
  declarations: [
    AppComponent,
    AllServicesComponent,
    MyServicesComponent,
    NewServiceComponent,
    DetailedServiceComponent,
    AboutComponent,
    LoginComponent,
    OfereceServicoComponent,
    TelaServicoComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSidenavModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
