import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-homeworks',
  standalone: true,
  imports: [RouterLink,NgFor],
  templateUrl: './homeworks.component.html',
  styleUrl: './homeworks.component.css'
})
export class HomeworksComponent implements OnInit {
@Input({required:true}) userId! :string
homeworksArray:any;

constructor(private http:HttpClient){}

ngOnInit(): void {
  this.loadData(1);
}

loadData(classId:number){
  this.http.get(`http://localhost:8080/homework/${classId}`,{observe:"response"}).subscribe(res=>{
    this.homeworksArray = res.body;
  })

}

}
