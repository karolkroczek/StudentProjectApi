import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-school-class',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './new-school-class.component.html',
  styleUrl: './new-school-class.component.css'
})
export class NewSchoolClassComponent {

constructor(private http:HttpClient){}


formGroup = new FormGroup({
  name: new FormControl(),
  startYear: new FormControl(),
  finishYear: new FormControl
})

handleSubmit(){
  this.http.post("http://localhost:8080/SchoolClass",this.formGroup.value,{observe:'response'}).subscribe(res=>{});
}

}
