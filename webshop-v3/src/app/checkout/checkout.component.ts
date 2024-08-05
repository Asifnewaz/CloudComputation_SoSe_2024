import { Component, OnInit } from '@angular/core';
import { LoadingComponent } from '../loading/loading.component';
import { DataServiceService } from '../services/data-service.service';
import { SessionServiceService } from '../services/session-service.service';
import { ShoppingCartService } from '../services/shopping-cart.service';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-checkout',
  standalone: true,
  imports: [LoadingComponent, CommonModule, RouterLink, RouterLinkActive, FormsModule, ReactiveFormsModule],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.css'
})
export class CheckoutComponent implements OnInit {
  public isLoading: boolean = false;
  public allProductInMyCart: any = [];
  public totalPrice: number = 0;

  constructor(private dataService: DataServiceService, private session: SessionServiceService, private cartService: ShoppingCartService, private router: Router) { }

  ngOnInit(): void {
    this.getTotalPrice();
  }

  getTotalPrice() {
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

  checkoutFormSubmit(checkoutForm: NgForm) {
    var formValue = {
      address: checkoutForm.value.address,
      city: checkoutForm.value.city,
      postCode: checkoutForm.value.postCode,
      country: checkoutForm.value.country
    };

    var url = 'makeOrder';
    this.dataService.postData(url, false, formValue).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        console.log(response);
        if (response.body.status == 200) {
          var orderId = 1234;
          this.router.navigate(['/payment-now', orderId]);
        }
      }
    });
  }

}
