import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  signUpForm: FormGroup
  showLogin = false;


  constructor(private authService: AuthService, private router: Router, private app: AppComponent) {
    this.loginForm = new FormGroup({
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    })

    this.signUpForm = new FormGroup({
      name: new FormControl('', Validators.required),
      cpf: new FormControl('', Validators.required),
      birthDate: new FormControl('', Validators.required),
      tel: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      neighborhood: new FormControl('', Validators.required)
    })
  }

  ngOnInit(): void {
  }

  login() {

    if(this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const password = this.loginForm.get('password')?.value;

      this.authService.login(email, password).subscribe(
        (data:any) => {
          sessionStorage.removeItem('userToken'),
          sessionStorage.setItem('userToken', data.token),
          this.app.isUserLoggedIn = true,
          this.router.navigate(['/all-services'])
        }
      )
    }
  }

  getToken() {
    return this.authService.getToken()
  }

  changeLoginExibition() {
    this.showLogin = !this.showLogin;
  }

  signUp() {

    if(this.signUpForm.valid) {
      let user = {
        name: this.signUpForm.get('name')?.value,
        cpf: this.signUpForm.get('cpf')?.value,
        birthDate: this.signUpForm.get('birthDate')?.value,
        cel: this.signUpForm.get('tel')?.value,
        email: this.signUpForm.get('email')?.value,
        pswd: this.signUpForm.get('password')?.value,
        city: this.signUpForm.get('city')?.value,
        neighborhood: this.signUpForm.get('neighborhood')?.value
      }

      this.authService.createUser(user).subscribe(
        (res) => {
          if(res.status === 200) {
            console.log(res)
            this.changeLoginExibition()
          }
        },
        (err) => {
          console.log(err)
          alert('dados inválidos!')
        }
      )

    }

  }

}
