import { Component } from '@angular/core';
import { DataServiceService } from '../services/data-service.service';
import { SessionServiceService } from '../services/session-service.service';
import { ActivatedRoute } from '@angular/router';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-order-status',
  standalone: true,
  imports: [NgFor],
  templateUrl: './order-status.component.html',
  styleUrl: './order-status.component.css'
})
export class OrderStatusComponent {
  public orderList: any = [];
  public productList: any = [];

  constructor(private dataService: DataServiceService, private session: SessionServiceService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.fetchAllOrders();
  }

  fetchAllOrders() {
    var orderId = this.router.snapshot.paramMap.get('order_id');

    var postData = {
      orderID: orderId
    }

    var url = "order/getDetailsOrder";
    this.dataService.postDataAsForm(url, false, postData).subscribe((response) => {
      if (response) {
        this.orderList = response.body.data;
        this.productList = response.body.data.cartList;
        console.log(this.productList);
      }
    });
  }
}
