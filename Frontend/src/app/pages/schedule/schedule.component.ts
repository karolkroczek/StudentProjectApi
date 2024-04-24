import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-schedule',
  standalone: true,
  imports: [
    NgFor
  ],
  templateUrl: './schedule.component.html',
  styleUrl: './schedule.component.css'
})
export class ScheduleComponent implements OnInit {
 @Input({ required: true })
  scheduleId!: string;
  planLekcji:Array<any>;
  daysOfWeek = ["Poniedzialek","Wtorek","Środa","Czwartek","Piątek"];

  constructor(private client:HttpClient){
    this.planLekcji = [];
  }

ngOnInit(){
  this.getScheduleInfo(9);
}

getScheduleInfo(num:number){
    const reqURL = `http://localhost:8080/schedules/${num}`
    this.client.get(reqURL,{
      observe:"response"
    }).subscribe(res=>{
      let object = JSON.parse(JSON.stringify(res.body))
      this.planLekcji[0] = object.poniedzialek;
      this.planLekcji[1] = object.wtorek;
      this.planLekcji[2] = object.sroda;
      this.planLekcji[3] = object.czwartek;
      this.planLekcji[4] = object.piatek;
    })
  }

}
