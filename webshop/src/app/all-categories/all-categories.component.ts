import { CommonModule, NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { DataServiceService } from '../services/data-service.service';
import { LoadingComponent } from '../loading/loading.component';

@Component({
  selector: 'app-all-categories',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive, NgFor, LoadingComponent],
  templateUrl: './all-categories.component.html',
  styleUrl: './all-categories.component.css'
})
export class AllCategoriesComponent implements OnInit {

  public isLoading: boolean = false;
  public category: any = [];

  constructor(private dataService: DataServiceService) { }

  ngOnInit(): void {
    this.fetchAllCategory();
    // this.fetchAllProduct();
  }

  fetchAllCategory() {
    this.isLoading = true;
    var url = 'categorylist';
    this.dataService.getData(url)
      .subscribe(response => {
        this.isLoading = false;
        this.category = response.body.data;
      });
  }

}
