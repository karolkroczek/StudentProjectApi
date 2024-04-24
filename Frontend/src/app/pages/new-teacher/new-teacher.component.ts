import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-teacher',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './new-teacher.component.html',
  styleUrl: './new-teacher.component.css'
})
export class NewTeacherComponent {

constructor(private http:HttpClient){

}

formGroup = new FormGroup({
  name: new FormControl(),
  surname: new FormControl(),
  password: new FormControl(),
  pesel: new FormControl(),
  grade: new FormControl(),
  phoneNumber: new FormControl(),
  emailAddress: new FormControl()
})


handleSubmit(){
const body = {
  teacherInfo:{
    name: this.formGroup.value.name,
    surname: this.formGroup.value.surname,
    grade:this.formGroup.value.grade,
    pesel: this.formGroup.value.pesel,
    phoneNumber: this.formGroup.value.phoneNumber,
    emailAddress: this.formGroup.value.emailAddress,
  },
  password: this.formGroup.value.password,
} 
console.log(body)
this.http.post("http://localhost:8080/teacher",body,{observe:"response"}).subscribe((res)=>{
  console.log("Poprawnie wysłano zapytanie");
})
}
}
