import { HttpClient } from '@angular/common/http';
import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';


enum activities{
  HOMEWORK = "Zadanie Domowe",
  QUIZ = "Sprawdzian",  
};

export type activitiesList = keyof typeof activities;

@Component({
  selector: 'app-lesson-activities-form',
  standalone: true,
  imports: [
  ReactiveFormsModule
  ],
  templateUrl: './lesson-activities-form.component.html',
  styleUrl: './lesson-activities-form.component.css'
})

export class LessonActivitiesFormComponent {
@Input({required:true}) activityName!: activitiesList;
  activityFormName!: string;

  constructor(private activatedRoute:ActivatedRoute,private http:HttpClient,private router:Router){

  }

  formGroup = new FormGroup({
    date: new FormControl(''),
    idClass: new FormControl(''),
    content: new FormControl('')
  })

ngOnInit(){
  this.activatedRoute.data.subscribe(res=>{
    this.activityName = res['activityName'];
    this.activityFormName = activities[this.activityName];
   })

  

}

handleSubmit(){
  if(this.activityName=='HOMEWORK'){
    const body = this.formGroup.value;
    console.log(body)
    this.http.post("http://localhost:8080/homework",body,{observe:"response"}).subscribe(res=>{
      
    this.router.navigateByUrl("main");
    })
    
  }else{
    this.activatedRoute.params.subscribe(res=>{
      const body = {
        description: this.formGroup.value.content,
        date: this.formGroup.value.date,
        classId:{id: this.formGroup.value.idClass}
      }
      this.http.post("http://localhost:8080/tests",body,{observe:"response"}).subscribe();
    })
  }
}

}
