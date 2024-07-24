import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { SessionServiceService } from '../services/session-service.service';

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent implements OnInit {
  public isLogin: any = false;
  public name: any = '';
  public sessiondata: any;

  constructor(private session: SessionServiceService) { }

  ngOnInit(): void {
    this.isLogin = this.session.isLogin();
    this.sessiondata = this.session.getSessiondata()
    this.name = this.sessiondata.userName;
    // console.log(this.sessiondata);
  }

  logOut() {
    this.session.destroySession();
  }
}
