import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AllCategoriesComponent } from './all-categories/all-categories.component';
import { ProductListComponent } from './product-list/product-list.component';
import { SingleProductComponent } from './single-product/single-product.component';
import { MyCartComponent } from './my-cart/my-cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { UserAreaComponent } from './user-area/user-area.component';
import { OrderStatusComponent } from './order-status/order-status.component';
import { PaymentFormComponent } from './payment-form/payment-form.component';
import { OrderListComponent } from './order-list/order-list.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },  //api no need
    { path: 'about', component: AboutUsComponent },  //api no need
    { path: 'contact', component: ContactUsComponent }, //api no need
    { path: 'login', component: LoginComponent }, //api ready
    { path: 'register', component: RegisterComponent }, //api no need
    { path: 'user-area', component: UserAreaComponent },
    { path: 'all-categories', component: AllCategoriesComponent }, //api ready
    { path: 'product-list/:category_id', component: ProductListComponent }, //api ready
    { path: 'product-details/:product_id', component: SingleProductComponent },
    { path: 'my-cart', component: MyCartComponent }, //api ready
    { path: 'checkout', component: CheckoutComponent }, //api ready
    { path: 'payment-now/:order-id', component: PaymentFormComponent }, //api ready
    { path: 'order-status', component: OrderStatusComponent },
    { path: 'order-list', component: OrderListComponent },

];

