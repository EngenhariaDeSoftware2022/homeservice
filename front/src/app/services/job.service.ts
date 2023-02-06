import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MyServicesComponent } from '../my-services/my-services.component';
import { AuthService } from './auth.service';

export interface IService {
  title: any,
  imgUrl: any,
  description: any,
  value: any,
  userTel: any,
  tag: any,
  city: any,
  neighborhood: any

}

interface jobs {
  jobs: IService[]
}

@Injectable({
  providedIn: 'root'
})
export class JobService {

  rootUrl = '/api/'
  httpOptions: any


  constructor(private authService: AuthService, private http: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${sessionStorage.getItem('userToken')}`
      }),
    withCredentials: true
    }
   }

  getServices() {
    return this.http.get(this.rootUrl + 'listJobs', this.httpOptions)
  }

  getUserServices() {
    return this.http.get(this.rootUrl + 'listUserJobs', this.httpOptions)
  }

  createService(service: any) {
    return this.http.post(this.rootUrl + 'createJob', service, this.httpOptions)
  }

  getTags() {
    return this.http.get(this.rootUrl + 'listTags', this.httpOptions)
  }

  deleteJob(id:any) {
    return this.http.delete(this.rootUrl + 'deleteJob' + `?jobId=${id}`, this.httpOptions)
  }

  getJobDetails(id:any) {
    return this.http.get(this.rootUrl + 'getJob' + `?jobId=${id}`, this.httpOptions)
  }

  getUserLoggedInDetails() {
    return this.http.get(this.rootUrl + 'getCurrentLoggedInDetails', this.httpOptions)
  }

}
