import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Banks} from "./banks";

@Injectable()
export class BankServiceService {

  private banksUrl: string;

  constructor(private http: HttpClient) {
    this.banksUrl = "http://localhost:8080/bank-post-and-get"
  }

  public findAll(): Observable<Banks[]> {
    return this.http.get<Banks[]>(this.banksUrl);
  }

  public save(bank : Banks) {
    return this.http.post<Banks>(this.banksUrl, bank);
  }}
