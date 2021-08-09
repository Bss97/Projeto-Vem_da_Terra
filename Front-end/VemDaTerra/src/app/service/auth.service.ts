import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { User } from '../model/User';
import { UserLogin } from '../model/UserLogin';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }

  login(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>('https://vemdaterra.herokuapp.com/usuario/login', userLogin)

  }

  cadastro(user: User): Observable<User> {
    return this.http.post<User>('https://vemdaterra.herokuapp.com/usuario/cadastrar', user)

  }

  logado() {
    let ok: boolean = false
    if (environment.token != '') {
      ok = true
    }
    return ok
  }
}