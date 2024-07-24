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

  constructor() {}

  addItem(item: CartItem): void {
    const items = this.itemsSubject.value;
    const existingItem = items.find(i => i.id === item.id);

    if (existingItem) {
      existingItem.quantity += item.quantity;
    } else {
      items.push(item);
    }

    this.itemsSubject.next(items);
  }

  removeItem(itemId: number): void {
    const items = this.itemsSubject.value.filter(item => item.id !== itemId);
    this.itemsSubject.next(items);
  }

  clearCart(): void {
    this.itemsSubject.next([]);
  }

  getTotalPrice(): number {
    return this.itemsSubject.value.reduce((total, item) => total + (item.price * item.quantity), 0);
  }
}
