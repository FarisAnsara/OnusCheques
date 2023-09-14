import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AppServiceService {

  private usersUrl: string;
  constructor(private http: HttpClient) {
    this.usersUrl = "http://localhost:8080"
  }

}
