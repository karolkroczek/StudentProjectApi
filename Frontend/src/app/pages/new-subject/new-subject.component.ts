import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AlertComponent } from '../../components/alert/alert.component';
import { ErrorComponent } from '../../components/error/error.component';
import { ModalComponent } from '../../components/modal/modal.component';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-new-subject',
  standalone: true,
  imports: [ReactiveFormsModule, NgFor,
    ModalComponent,
    AlertComponent, NgIf,
    ErrorComponent
],
  templateUrl: './new-subject.component.html',
  styleUrl: './new-subject.component.css'
})

export class NewSubjectComponent {

  formGroup = new FormGroup({
    name: new FormControl(),
    description: new FormControl(),
  })
  
  constructor(private http:HttpClient){}


  handleSubmit(){
    console.log(this.formGroup.value.name);
    const body={
      ...this.formGroup.value};
    this.http.post("http://localhost:8080/subject",body,{observe:'response'}).subscribe(res=>{
      console.log("Wysłano zapytanie: "+body);
    })
  }

}
