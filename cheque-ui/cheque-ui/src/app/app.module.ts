import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BanksComponent } from './Bank/banks/banks.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatOptionModule} from "@angular/material/core";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import {HomeComponent} from "./home/home.component";
import { CustomerComponent } from './customer/customer.component';
import { ChequesComponent } from './cheques/cheques.component';
import { BankLidtComponent } from './Bank/banks/bank-lidt/bank-lidt.component';
import { BankFormComponent } from './Bank/banks/bank-form/bank-form.component';
import {BankServiceService} from "./Bank/banks/bank-service.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { BranchesComponent } from './branches/branches.component';
import { FormBranchesComponent } from './branches/form-branches/form-branches.component';
import { ListBranchesComponent } from './branches/list-branches/list-branches.component';

@NgModule({
  declarations: [
    AppComponent,
    BanksComponent,
      HomeComponent,
      BranchesComponent,
      CustomerComponent,
      ChequesComponent,
      BankLidtComponent,
      BankFormComponent,
      BranchesComponent,
      FormBranchesComponent,
      ListBranchesComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        MatSidenavModule,
        BrowserAnimationsModule,
        FormsModule,
        MatToolbarModule,
        MatOptionModule,
        MatIconModule,
        MatListModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
  providers: [BankServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
