import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-director',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './new-director.component.html',
  styleUrl: './new-director.component.css'
})
export class NewDirectorComponent {
  constructor(private http:HttpClient){

  }
  
  formGroup = new FormGroup({
    name: new FormControl(),
    surname: new FormControl(),
    password: new FormControl(),
    passwordRepeat: new FormControl(),

  })
  
  
  handleSubmit(){
  const body = this.formGroup.value;
  console.log(body)
  this.http.post("http://localhost:8080/teacher",body,{observe:"response"}).subscribe((res)=>{
    console.log("Poprawnie wysłano zapytanie");
  })
  }
}
