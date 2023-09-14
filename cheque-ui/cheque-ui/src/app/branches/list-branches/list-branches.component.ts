import {Component, OnInit} from '@angular/core';
import {BranchServiceService} from "../branch-service.service";
import {Branches} from "../branches";

@Component({
  selector: 'app-list-branches',
  templateUrl: './list-branches.component.html',
  styleUrls: ['./list-branches.component.css']
})
export class ListBranchesComponent implements OnInit{

  branches!: Branches[];

  constructor(private branchService: BranchServiceService) {
  }

  ngOnInit() {
    this.branchService.findAll().subscribe(data => {
      console.log(data);
      this.branches = data;
    })
  }

}
