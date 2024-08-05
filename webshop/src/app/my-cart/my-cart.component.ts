import { CommonModule, NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { SessionServiceService } from '../services/session-service.service';
import { LoadingComponent } from '../loading/loading.component';
import { ShoppingCartService } from '../services/shopping-cart.service';

@Component({
  selector: 'app-my-cart',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, NgFor, LoadingComponent],
  templateUrl: './my-cart.component.html',
  styleUrl: './my-cart.component.css'
})
export class MyCartComponent implements OnInit {
  public isLoading: boolean = false;
  public allProductInMyCart: any = [];
  public totalPrice: number = 0;

  constructor(private dataService: DataServiceService, private session: SessionServiceService, private cartService: ShoppingCartService) { }

  ngOnInit(): void {
    this.fetchAllProductInMyCart();
  }

  fetchAllProductInMyCart() {
    var url = 'cartList';

    var userID = {
      userID: this.session.getAccessToken()
    }

    this.dataService.postData(url, false, userID).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        if (response.body.status == 200) {
          console.log(response);
          this.allProductInMyCart = response.body.data;
          this.totalPrice = this.cartService.getTotalPrice(this.allProductInMyCart);
          console.log(this.totalPrice);
        }
      }
    });
  }
}
