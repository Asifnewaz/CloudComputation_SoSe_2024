import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-payment-form',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive, FormsModule, ReactiveFormsModule],
  templateUrl: './payment-form.component.html',
  styleUrl: './payment-form.component.css'
})
export class PaymentFormComponent {

  public expiration: string = "";
  public paymentStatus: boolean = true;

  // var postingId = this.route.snapshot.paramMap.get('id');

  modelChange(str: string): void {
    this.expiration = str;
    if (this.expiration.length == 2) {
      this.expiration = this.expiration + "/";
    }
  }

  displayLoadingPayment() {
    setTimeout(() => {
      this.paymentStatus = false;
    }, 3000);
  }
}
