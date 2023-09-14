import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Branches} from "./branches";
import {Banks} from "../Bank/banks/banks";

@Injectable({
  providedIn: 'root'
})
export class BranchServiceService {

  private branchUrl: string;

  constructor(private http: HttpClient) {
    this.branchUrl = "http://localhost:8080/branch-post-and-get"
  }

  public findAll(): Observable<Branches[]> {
    return this.http.get<Branches[]>(this.branchUrl);
  }
  public save(branch : Branches) {
    return this.http.post<Branches>(this.branchUrl, branch);
  }
}
