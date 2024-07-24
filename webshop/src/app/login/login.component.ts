import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { SessionServiceService } from '../services/session-service.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive, FormsModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  public isLoading: boolean = false;
  public errorMessage: any = '';

  constructor(
    private dataService: DataServiceService,
    private session: SessionServiceService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.checkAlreadyLogin();
  }

  checkAlreadyLogin() {
    if (this.session.isLogin()) {
      this.router.navigate(['/']);
    }
  }

  loginFormSubmit(loginForm: NgForm) {
    this.isLoading = true;

    var formValue = {
      username: loginForm.value.username,
      password: loginForm.value.password,
    };

    var url = 'https://1d9d857a-4e50-4c6c-8dcf-ca3efeab783d.mock.pstmn.io/login';
    this.dataService.postData(url, false, formValue).subscribe((response) => {
      this.isLoading = true;

      if (response) {
        this.isLoading = false;
        console.log(response);
        if (response.body.status == 200) {
          var sessionData = {
            userID: response.body.data.userID,
            name: response.body.data.name,
            image: response.body.data.image
          };
          this.session.storeSession(sessionData);
        } else {
          this.errorMessage = response.body.error_message;
        }
      }
    });
  }
}
