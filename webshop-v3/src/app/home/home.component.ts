import { CommonModule, NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { LoadingComponent } from '../loading/loading.component';
import { SessionServiceService } from '../services/session-service.service';

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

  constructor(private dataService: DataServiceService, private session: SessionServiceService) { }

  ngOnInit(): void {
    this.fetchAllCategory();
    this.fetchAllProduct();
  }

  fetchAllCategory() {
    this.isLoading = true;
    var url = 'category/get';
    this.dataService.getData(url)
      .subscribe(response => {
        this.isLoading = false;
        this.category = response.body.data;
      });
  }

  fetchAllProduct() {
    this.isLoading = true;
    var url = 'product/get';
    this.dataService.getData(url)
      .subscribe(response => {
        this.isLoading = false;
        this.productList = response.body.data;
      });
  }

  addItemToCart(product_id: number, quantity: number): void {
    var userId = this.session.getAccessToken();

    var postData = {
      user_id: userId,
      product_id: product_id,
      quantity: quantity
    }


    var url = 'cart/addToCart';
    this.dataService.postDataAsForm(url, false, postData).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        console.log(response);

      }
    });
  }

}
