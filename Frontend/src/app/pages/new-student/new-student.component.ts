import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-student',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './new-student.component.html',
  styleUrl: './new-student.component.css'
})
export class NewStudentComponent {

formGroup = new FormGroup({
  name: new FormControl(),
  surname: new FormControl(),
  birthDate: new FormControl(),
  address: new FormControl(),
  password: new FormControl(),
  pesel: new FormControl(),
  phoneNumber: new FormControl(),
  emailAddress: new FormControl(),
  parentName: new FormControl(),
  parentSurname: new FormControl(),
  paretEmailAddress: new FormControl(),
  parentPhoneNumber: new FormControl(),
})

constructor(private http:HttpClient){

}

handleSubmit(){
  const body ={
    studentInfo:{
      name: this.formGroup.value.name,
      surname: this.formGroup.value.surname,
      birthDate: this.formGroup.value.birthDate,
      address: this.formGroup.value.address,
      pesel: this.formGroup.value.pesel,
      phoneNumber: this.formGroup.value.phoneNumber,
      emailAddress: this.formGroup.value.emailAddress,
      parentName: this.formGroup.value.parentName,
      parentSurname: this.formGroup.value.parentSurname,
      paretEmailAddress: this.formGroup.value.paretEmailAddress,
      parentPhoneNumber:this.formGroup.value.parentPhoneNumber,
    },
    password: this.formGroup.value.password,
  } ;
  console.log(body)
  this.http.post("http://localhost:8080/student",body,{observe:"response"}).subscribe((res)=>{
    console.log("Poprawnie wysłano zapytanie");
  })
  }

}
