import { CommonModule } from '@angular/common';
import { Component, NgModule, OnInit } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { SessionServiceService } from '../services/session-service.service';
import { FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import { DataServiceService } from '../services/data-service.service';
import { FilterPipe } from '../pipes/filter.pipe';

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, ReactiveFormsModule, FormsModule, FilterPipe],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent implements OnInit {
  public isLogin: any = false;
  public name: any = '';
  public sessiondata: any;
  public productList: any = [];

  public searchSuggestion = "";

  public searchText: any = "";

  constructor(private session: SessionServiceService, private dataService: DataServiceService) { }

  ngOnInit(): void {
    this.isLogin = this.session.isLogin();
    this.sessiondata = this.session.getSessiondata()
    this.name = this.sessiondata.userName;
    // console.log(this.sessiondata);
    this.getAllProducts();
  }

  logOut() {
    this.session.destroySession();
  }


  getAllProducts() {
    var url = 'product/get';
    this.dataService.getData(url)
      .subscribe(response => {
        this.productList = response.body.data;
      });
  }


  search(term: string): void {
    console.log(term);

    if (term.length > 0) {
      this.searchSuggestion = "searchSuggestion";
    } else {
      this.searchSuggestion = "";
    }
  }


}






