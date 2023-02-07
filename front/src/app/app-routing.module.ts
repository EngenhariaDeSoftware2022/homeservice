import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AllServicesComponent } from './all-services/all-services.component';
import { DetailedServiceComponent } from './detailed-service/detailed-service.component';
import { MyServicesComponent } from './my-services/my-services.component';
import { NewServiceComponent } from './new-service/new-service.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { OfereceServicoComponent } from './oferece-servico/oferece-servico.component';
import { TelaServicoComponent } from './tela-servico/tela-servico.component';
import { AuthGuard } from './auth.guard';
import { AppComponent } from './app.component';



const routes: Routes = [
  
  {
    path: 'all-services',
    
    component: AllServicesComponent
  },
  {
    path: 'detailed-service',
    
    component: DetailedServiceComponent
  },
  {
    path: 'my-services',
    
    component: MyServicesComponent
  },
  {
    path: 'new-service',
    
    component: NewServiceComponent
  },
  {
    path: 'about',
    
    component: AboutComponent
  },
  {
    path: 'oferece-servico',
    
    component: OfereceServicoComponent
  },
  {
  path:'servico',
  
  component: TelaServicoComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
