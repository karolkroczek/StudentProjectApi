import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-day-schedule',
  standalone: true,
  imports: [
    NgFor,ReactiveFormsModule
  ],
  templateUrl: './new-day-schedule.component.html',
  styleUrl: './new-day-schedule.component.css'
})
export class NewDayScheduleComponent implements OnInit {

loadedData:any = [];

constructor(private http:HttpClient){

}

formGroup = new FormGroup({
  pierwszaLekcja:new FormControl(),
  drugaLekcja:new FormControl(),
  trzeciaLekcja:new FormControl(),
  czwartaLekcja:new FormControl(),
  piataLekcja:new FormControl(),
});

ngOnInit(): void {
  this.loadData();
}
loadData(){
  this.http.get("http://localhost:8080/subject",{observe:'response'}).subscribe(res=>{
  this.loadedData= res.body;
  console.log(res.body)
  })

}

handleSubmit(){
  const body={
    pierwszaLekcja:{id:this.formGroup.value.pierwszaLekcja},
    drugaLekcja:{id:this.formGroup.value.drugaLekcja},
    trzeciaLekcja:{id:this.formGroup.value.trzeciaLekcja},
    czwartaLekcja:{id:this.formGroup.value.czwartaLekcja},
    piataLekcja:{id:this.formGroup.value.piataLekcja},

  }


  this.http.post("http://localhost:8080/daySchedule",body).subscribe(res=>{})
}

}
