import { CommonModule, NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { LoadingComponent } from '../loading/loading.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgFor, CommonModule, RouterOutlet, RouterLink, RouterLinkActive, LoadingComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  public isLoading: boolean = false;
  public category: any = [];
  public productList: any = [];

  constructor(private dataService: DataServiceService) { }

  ngOnInit(): void {
    this.fetchAllCategory();
    // this.fetchAllProduct();
  }

  fetchAllCategory() {
    this.isLoading = true;
    var url = 'categorylist';
    this.dataService.getData(url)
      .subscribe(response => {
        this.isLoading = false;
        this.category = response.body.data;
      });
  }

  fetchAllProduct() {
    this.isLoading = true;
    var url = 'productist';
    this.dataService.getData(url)
      .subscribe(response => {
        this.isLoading = false;
        this.productList = response.body.data;
      });
  }

}
