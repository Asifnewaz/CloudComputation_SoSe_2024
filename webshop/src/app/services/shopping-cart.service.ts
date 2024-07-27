import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


export interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}


@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  private itemsSubject = new BehaviorSubject<CartItem[]>([]);
  items$ = this.itemsSubject.asObservable();

  constructor() { }

  getTotalPrice(allProductInMyCart: any): number {
    var totalPrice = 0;
    for (let item of allProductInMyCart) {
      totalPrice += (item.price * item.quantity);
    }
    return totalPrice;
  }
}
