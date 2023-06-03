import { Component } from '@angular/core';

@Component({
  selector: 'app-forbidden',
  templateUrl: './forbidden.component.html',
  styleUrls: ['./forbidden.component.css']
})
export class ForbiddenComponent {
  removeUserRole() {
    localStorage.clear(); // Remove the userRole from localStorage
  }
}
