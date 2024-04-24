import { Component, Input } from '@angular/core';
import { ErrorComponent } from '../../components/error/error.component';
import { Router, RouterLink } from '@angular/router';
import { AppService } from '../../services/app.service';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ErrorComponent,RouterLink,ReactiveFormsModule,NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers:[AppService],
})
export class LoginComponent {

  errorState:Boolean = false;
  sendControlState:Boolean = false;

  Loginform = new FormGroup({
    emailAddress : new FormControl('',Validators.required), 
    password : new FormControl('',Validators.required), 
  });

  constructor(private service:AppService, private http:HttpClient,private router:Router){}

  handleSubmit(){
      this.http.post<any>('http://localhost:8080/users',{
        emailAddress: this.Loginform.value.emailAddress||"",
        password: this.Loginform.value.password||""
      },{
        observe:'response'
      })
      .subscribe(res=>{
        this.sendControlState = true;
        if(res.body){
          console.log(res.body.role);
          document.cookie = "userInfo="+JSON.stringify(res.body);
          window.sessionStorage.setItem("role",res.body.role);
          window.sessionStorage.setItem("logged","true");
          
          this.router.navigateByUrl("/main");


        }else{
          console.error("Nie znaleziono okreslonego uzytkownika");
          this.errorState = true;

        }
      })
    
  }

  navigateToFirst(){
    this.router.navigateByUrl("/first");
  }
}
