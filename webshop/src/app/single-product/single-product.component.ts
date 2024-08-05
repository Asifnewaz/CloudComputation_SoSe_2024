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
  // var postingId = this.route.snapshot.paramMap.get('id');
  public isLoading: boolean = false;
  public productDetails: any = "";

  constructor(private dataService: DataServiceService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.fetchProductDetails();
  }

  fetchProductDetails() {
    var url = 'productWithID';
    var productInfo = {
      product_id: this.router.snapshot.paramMap.get('product_id')
    }

    this.dataService.postData(url, false, productInfo).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        if (response.body.status == 200) {
          this.productDetails = response.body.data;
          console.log(this.productDetails);
        }
      }
    });
  }

}
