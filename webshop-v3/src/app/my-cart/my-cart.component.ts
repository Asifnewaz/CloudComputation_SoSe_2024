import { CommonModule, NgFor } from '@angular/common';
import { Component, NgModule, OnInit } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { SessionServiceService } from '../services/session-service.service';
import { LoadingComponent } from '../loading/loading.component';
import { ShoppingCartService } from '../services/shopping-cart.service';
import { NgModel, ReactiveFormsModule } from '@angular/forms';
import { pid } from 'process';

@Component({
  selector: 'app-my-cart',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, NgFor, LoadingComponent, ReactiveFormsModule],
  templateUrl: './my-cart.component.html',
  styleUrl: './my-cart.component.css'
})
export class MyCartComponent implements OnInit {
  public isLoading: boolean = false;
  public allProductInMyCart: any = [];
  public totalPrice: number = 0;
  public selectedValue: string = '';

  constructor(private dataService: DataServiceService, private session: SessionServiceService, private cartService: ShoppingCartService) { }

  ngOnInit(): void {
    this.fetchAllProductInMyCart();
  }

  fetchAllProductInMyCart() {
    this.totalPrice = 0;
    var url = 'cart/cartList';


    var userId = this.session.getAccessToken();

    var postData = {
      user_id: userId
    }

    this.dataService.postDataAsForm(url, false, postData).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        this.allProductInMyCart = response.body.data;

        for (let item of this.allProductInMyCart) {
          this.totalPrice += (item.price * item.quantity);
        }

      }
    });
  }


  removeItemFromCart(itemId: any): void {
    var url = 'cart/deleteCart';

    var userId = this.session.getAccessToken();

    var postData = {
      user_id: userId,
      cart_id: itemId
    }

    this.dataService.postDataAsForm(url, false, postData).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        this.fetchAllProductInMyCart();

      }
    });
  }


  addOrMinusItemToCart(cartID: number, quantity: number): void {

    var postData = {
      cartID: cartID,
      quantity: quantity
    }


    var url = 'cart/increaseQuantity';
    this.dataService.postDataAsForm(url, false, postData).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        console.log(response);

      }
    });
  }

  addOneMore(pId: any) {
    var getExistingQuantity;
    var isQuantityAvailable;
    var isProductAvailable;

    console.log(this.allProductInMyCart);

    for (let item of this.allProductInMyCart) {
      if (item.id == pId) {
        getExistingQuantity = item.quantity;
        isQuantityAvailable = item.quantity;
        isProductAvailable = item.available;
      }
    }

    if (isQuantityAvailable < isProductAvailable) {
      this.addOrMinusItemToCart(pId, getExistingQuantity + 1);
      this.fetchAllProductInMyCart();
    } else {
      alert("product out of stock!!");
    }

  }

  addMinusOne(pId: any) {
    var getExistingQuantity;
    var isQuantityAvailable;
    var isProductAvailable;

    console.log(this.allProductInMyCart);

    for (let item of this.allProductInMyCart) {
      if (item.id == pId) {
        getExistingQuantity = item.quantity;
        isQuantityAvailable = item.quantity;
        isProductAvailable = item.available;
      }
    }

    if (getExistingQuantity > 1) {
      this.addOrMinusItemToCart(pId, getExistingQuantity - 1);
      this.fetchAllProductInMyCart();
    } else {
      alert("Invalid action!!");
    }
  }


}
