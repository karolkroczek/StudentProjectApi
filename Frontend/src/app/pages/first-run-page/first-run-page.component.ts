import { Component } from '@angular/core';
import { NewDirectorComponent } from '../new-director/new-director.component';
import { NewSubjectComponent } from "../new-subject/new-subject.component";
import { NewDayScheduleComponent } from "../new-day-schedule/new-day-schedule.component";
import { NewSchoolClassComponent } from "../new-school-class/new-school-class.component";
import { NewScheduleComponent } from "../new-schedule/new-schedule.component";
import { NgIf } from '@angular/common';
import { Router } from '@angular/router';

@Component({
    selector: 'app-first-run-page',
    standalone: true,
    templateUrl: './first-run-page.component.html',
    styleUrl: './first-run-page.component.css',
    imports: [NewDirectorComponent, NewSubjectComponent, NewDayScheduleComponent, NewSchoolClassComponent, NewScheduleComponent,NgIf]
})
export class FirstRunPageComponent {
step=0;

constructor(private router:Router){}

nextStep(){
  this.step=this.step+1;
  if(this.step == 5){
    this.router.navigateByUrl("/login");
  }
}

}
