import { NgClass, NgComponentOutlet, NgFor, NgForOf, NgIf, NgPlural, NgStyle, NgSwitch, NgTemplateOutlet } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-loading',
  standalone: true,
  imports: [NgClass, NgComponentOutlet, NgForOf, NgIf, NgFor, NgPlural, NgStyle, NgSwitch, NgTemplateOutlet],
  templateUrl: './loading.component.html',
  styleUrl: './loading.component.css'
})
export class LoadingComponent {
  @Input() isLoading: any;

  constructor() { }

  ngOnInit(): void { }
}
