import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CoreService } from '../_services/core.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  userForm: FormGroup;

  @Output() formSubmitted = new EventEmitter<{ houseNumber: number, phoneNumber: string }>();

  constructor(private fb: FormBuilder,private _coreService : CoreService) {
    this.userForm = this.fb.group({
      HouseNo: '',
      PhNo: ''
    })
  }

  registerUser() {
    const houseNumber = this.userForm.get('HouseNo').value;
    const phoneNumber = this.userForm.get('PhNo').value;
    if(houseNumber == ''){
      this._coreService.openSnackBar("Please Enter House Number !!");
    }else if(phoneNumber == '' || phoneNumber.length != 10){
      this._coreService.openSnackBar("Please Enter 10 digit Phone Number !!");
    }else{
      this.formSubmitted.emit({ houseNumber, phoneNumber });
    }
  }
}
