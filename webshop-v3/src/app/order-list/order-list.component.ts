import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { SessionServiceService } from '../services/session-service.service';

@Component({
  selector: 'app-order-list',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './order-list.component.html',
  styleUrl: './order-list.component.css'
})
export class OrderListComponent {
  public orderList: any = [];

  constructor(private dataService: DataServiceService, private session: SessionServiceService) { }

  ngOnInit(): void {
    this.fetchAllOrders();
  }

  fetchAllOrders() {
    var userId = this.session.getAccessToken();

    var postData = {
      userid: userId
    }

    var url = "order/get";
    this.dataService.postDataAsForm(url, false, postData).subscribe((response) => {
      if (response) {
        this.orderList = response.body.data;
      }
    });
  }




}
