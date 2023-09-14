import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BanksComponent} from "./Bank/banks/banks.component";
import {HomeComponent} from "./home/home.component";
// import {BranchesComponent} from "./branches/branches.component";
import {CustomerComponent} from "./customer/customer.component";
import {ChequesComponent} from "./cheques/cheques.component";
import {BankLidtComponent} from "./Bank/banks/bank-lidt/bank-lidt.component";
import {BankFormComponent} from "./Bank/banks/bank-form/bank-form.component";
import {BranchesComponent} from "./branches/branches.component";

const routes: Routes = [
  {
    path: 'banks',
    component: BanksComponent,
  },{
    path: 'home',
    component: HomeComponent,
  },
  {path: "branches",
    component: BranchesComponent
  },
  {path: "customers",
  component: CustomerComponent
  },
  {path: "cheques",
  component: ChequesComponent
  },
  {
    path: "banks/bank-post-and-get",
  component: BankLidtComponent
  },
  {
    path: "banks/addBank",
  component: BankFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
