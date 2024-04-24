import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-schedule',
  standalone: true,
  imports: [ReactiveFormsModule,NgFor],
  templateUrl: './new-schedule.component.html',
  styleUrl: './new-schedule.component.css'
})
export class NewScheduleComponent implements OnInit {

  loadedData:any = [];

  constructor(private http:HttpClient){}

  formGroup = new FormGroup({
    poniedzialek:new FormControl(),
    wtorek:new FormControl(),
    sroda:new FormControl(),
    czwartek:new FormControl(),
    piatek:new FormControl()
  })


  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
    this.http.get("http://localhost:8080/daySchedule",{observe:'response'}).subscribe(res=>{
      this.loadedData=res.body;
    })
  }

  handleSubmit(){
    const body = {
      poniedzialek:{scheduleId:this.formGroup.value.poniedzialek},
      wtorek:{scheduleId:this.formGroup.value.wtorek},
      sroda:{scheduleId:this.formGroup.value.sroda},
      czwartek:{scheduleId:this.formGroup.value.czwartek},
      piatek:{scheduleId:this.formGroup.value.piatek},
    }
    this.http.post("http://localhost:8080/schedules",body,{observe:'response'}).subscribe(res=>{})
  }

}
