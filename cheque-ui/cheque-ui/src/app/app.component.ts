import {Component, OnInit} from '@angular/core';
import {HOME} from "@angular/cdk/keycodes";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Onus Cheque';

  openSideBar : boolean = true;

  menuSideBar = [
    {
      linkName: "Home",
      link: "/home",
      icon: "home",
      showSubmenu : false,
      subMenu: []
    },
    {
      linkName: "Banks",
      link: "/banks",
      icon: "business_center",
      showSubmenu : false,
      subMenu: [
        {
          linkName: "Get Branches",
          link: "/get-banks"
        },
        {
          linkName: "Add Branches",
          link: "/post-banks"
        }
      ]
    },
    {
      linkName: "Branches",
      link: "/branches",
      icon: "call_split",
      showSubmenu : false,
      subMenu: [
        {
          linkName: "Get Branches",
          link: "/get-branches"
        },
        {
          linkName: "Add Branches",
          link: "/post-branches"
        }
      ]
    },
    {
      linkName: "Customers",
      link: "/customers",
      icon: "person_pin",
      showSubmenu : false,
      subMenu: [
        {
          linkName: "Get Customers",
          link: "/get-customers"
        },
        {
          linkName: "Add Branches",
          link: "/post-customer"
        }
      ]
    },
    {
      linkName: "Cheques",
      link: "/cheques",
      icon: "check",
      showSubmenu : false,
      subMenu: [
        {
          linkName: "Get Cheques",
          link: "/get-cheques"
        },
        {
          linkName: "Add Cheques",
          link: "/post-cheques"
        }
      ]
    }
  ]
  showMenu: boolean = false;
  constructor(private router:Router) {
  }

  ngOnInit(): void {
    this.router.navigate(['/home'])
  }

  toggleSubMeny() {
    this.showMenu = !this.showMenu;
  }

  protected readonly Component = Component;
}
