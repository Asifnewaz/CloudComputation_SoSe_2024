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

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'about', component: AboutUsComponent },
    { path: 'contact', component: ContactUsComponent },
    { path: 'user-area', component: UserAreaComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'all-categories', component: AllCategoriesComponent },
    { path: 'product-list', component: ProductListComponent },
    { path: 'product-details', component: SingleProductComponent },
    { path: 'my-cart', component: MyCartComponent },
    { path: 'checkout', component: CheckoutComponent },
    { path: 'order-status', component: OrderStatusComponent },

];

