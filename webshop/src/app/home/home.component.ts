import { CommonModule, NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { LoadingComponent } from '../loading/loading.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgFor, CommonModule, RouterOutlet, RouterLink, RouterLinkActive, LoadingComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  public isLoading: boolean = true;

  category: any = [];

  constructor(private dataService: DataServiceService) { }

  ngOnInit(): void {
    this.fetchAllCategory();
  }

  fetchAllCategory() {
    var url = 'https://official-joke-api.appspot.com/random_joke';
    this.dataService.getData(url)
      .subscribe(data => {
        console.log(data);

        this.isLoading = false;
        // this.category = data.body.data;
        // if (this.category) {
        //   this.category = this.post.reverse();
        // }
      });

  }

}
