import { trigger, state, style, transition, animate } from '@angular/animations';
import { Component } from '@angular/core';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
  animations: [
    trigger('fadeIn', [
      state('void', style({
        opacity: 0
      })),
      transition(':enter', [
        animate(500)
      ])
    ])
  ]
})

export class FooterComponent {
  date = formatDate(new Date(), 'MMM yyyy', 'en-US');
}

