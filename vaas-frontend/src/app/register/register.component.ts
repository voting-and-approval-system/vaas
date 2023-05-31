import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  userForm: FormGroup;

  @Output() formSubmitted = new EventEmitter<{ houseNumber: number, phoneNumber: string }>();

  constructor(private fb: FormBuilder) {
    this.userForm = this.fb.group({
      HouseNo: '',
      PhNo: ''
    })
  }

  registerUser() {
    const houseNumber = this.userForm.get('HouseNo').value;
    const phoneNumber = this.userForm.get('PhNo').value;

    this.formSubmitted.emit({ houseNumber, phoneNumber })
  }
}
