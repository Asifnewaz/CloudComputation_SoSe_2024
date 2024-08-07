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
    this.fetchAllProductInMyCart();
  }

  fetchAllProductInMyCart() {
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
          this.totalPrice += item.price;
        }

      }
    });
  }

  checkoutFormSubmit(checkoutForm: NgForm) {

    var userId = this.session.getAccessToken();


    var formValue = {
      userid: userId,
      address: checkoutForm.value.address,
      name: checkoutForm.value.city,
      mobile_number: checkoutForm.value.postCode,
      email_address: checkoutForm.value.email_address
    };

    var url = 'order/makeOrder';

    this.dataService.postDataAsForm(url, false, formValue).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;

        formValue.email_address;
        
        this.router.navigate(['/payment-now', response.body.data.id]);

      }
    });


  }

}
