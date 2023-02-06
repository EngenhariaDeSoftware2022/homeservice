import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { map } from 'rxjs';

export interface IUser {
  birthDate: string,
    cel: string,
    cpf: string,
    email: string,
    id: number,
    location: {
      city: string,
      id: number,
      neighborhood: string
    },
    name: string,
    pswd: string
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private token!: string;
  onSignIn = new EventEmitter<boolean>()
  rootUrl = '/api/'

  users: IUser[] = []

  constructor(private http: HttpClient) {
  }

  ngOnInit() {

  }
  login(email: string, password: string) {
    console.log(email, password)
    return this.http.post(this.rootUrl + '/auth/authenticate', {email: email, password:password})

  }

  getToken() {
    return this.token;
  }

  logout() {
    sessionStorage.removeItem('userToken')
    this.onSignIn.emit(false)
  }

  createUser(user: any) {

    return this.http.post(this.rootUrl + '/auth/register', user, {observe: 'response'});
  }


}
