import { CommonModule, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive, ActivatedRoute } from '@angular/router';
import { LoadingComponent } from '../loading/loading.component';
import { DataServiceService } from '../services/data-service.service';
import { SessionServiceService } from '../services/session-service.service';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, NgFor, LoadingComponent],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {
  public isLoading: boolean = false;
  public productList: any = [];
  public category_id: any;
  public productListSorted: any = [];


  constructor(private dataService: DataServiceService, private router: ActivatedRoute, private session: SessionServiceService) { }

  ngOnInit(): void {
    this.fetchAllProduct();
  }

  fetchAllProduct() {
    this.category_id = this.router.snapshot.paramMap.get('category_id');
    this.isLoading = true;
    var url = 'product/get';
    this.dataService.getData(url)
      .subscribe(response => {
        this.isLoading = false;
        this.productList = response.body.data;
        for (var item of this.productList) {
          if (item.category_id == this.category_id) {
            this.productListSorted.push(item);
          }
        }
        console.log(this.productListSorted);
      });
  }

  addItemToCart(product_id: number, quantity: number): void {
    var userId = this.session.getAccessToken();
    console.log(userId);
    console.log(product_id);
    console.log(quantity);
  }

}
