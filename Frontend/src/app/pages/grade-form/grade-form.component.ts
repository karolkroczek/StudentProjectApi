import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-grade-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './grade-form.component.html',
  styleUrl: './grade-form.component.css'
})
export class GradeFormComponent implements OnInit {
@Input({required:true}) studentName! :string

constructor(private activatedRoute:ActivatedRoute,private http:HttpClient){

}

ngOnInit(): void {
  this.activatedRoute.params.subscribe(res=>{
    this.studentName=res['id'];
  })
}

formGroup = new FormGroup({
  idStudent:new FormControl(0),
  mark: new FormControl(0),
  description: new FormControl(''),
  finalMark: new FormControl(false),
})

handleSubmit(){
  this.formGroup.value.idStudent = +this.studentName;
  const body = this.formGroup.value;
  console.log(body);
  this.http.post("http://localhost:8080/marks",body,{observe:"response"}).subscribe();
}

}
