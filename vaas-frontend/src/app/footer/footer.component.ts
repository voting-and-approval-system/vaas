// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-footer',
//   templateUrl: './footer.component.html',
//   styleUrls: ['./footer.component.css']
// })
// export class FooterComponent {

// }
import { trigger, state, style, transition, animate } from '@angular/animations';
import { Component } from '@angular/core';

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

export class FooterComponent {}

