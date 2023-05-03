import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsersService } from '../_services/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  constructor(private usersService: UsersService){
    
  }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  login(loginForm:NgForm)
  {
    this.usersService.login(loginForm.value).subscribe(
      (response)=>{
        console.log(response);
      },
      (error)=>{
        console.log(error);
      }
    );
  }
}
