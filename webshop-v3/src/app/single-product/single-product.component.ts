import { Component, OnInit } from '@angular/core';
import { DataServiceService } from '../services/data-service.service';
import { LoadingComponent } from '../loading/loading.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-single-product',
  standalone: true,
  imports: [LoadingComponent],
  templateUrl: './single-product.component.html',
  styleUrl: './single-product.component.css'
})
export class SingleProductComponent implements OnInit {
  public isLoading: boolean = false;
  public productDetails: any = "";
  public productList: any = [];


  constructor(private dataService: DataServiceService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.fetchAllProduct();
  }

  // fetchProductDetails() {
  //   var url = 'product/productWithID';

  //   var productInfo = {
  //     productID: this.router.snapshot.paramMap.get('product_id')
  //   }

  //   this.dataService.postData(url, false, productInfo).subscribe((response) => {
  //     this.isLoading = true;

  //     if (response) {
  //       // console.log(response);
  //       this.isLoading = false;
  //       // this.productDetails = response.body.data;
  //     }
  //   });
  // }

  fetchAllProduct() {

    var productId = this.router.snapshot.paramMap.get('product_id');

    this.isLoading = true;
    var url = 'product/get';
    this.dataService.getData(url)
      .subscribe(response => {
        this.isLoading = false;
        this.productDetails = response.body.data;
        for (let item of this.productDetails) {
          if (item.id == productId) {
            this.productDetails = item;
          }
        }
        console.log(this.productDetails);
      });
  }

}
