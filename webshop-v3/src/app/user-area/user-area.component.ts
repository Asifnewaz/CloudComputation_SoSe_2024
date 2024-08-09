import { CommonModule, NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-user-area',
  standalone: true,
  imports: [NgFor,CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './user-area.component.html',
  styleUrl: './user-area.component.css'
})
export class UserAreaComponent {

}
