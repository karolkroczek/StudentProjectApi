import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teacher-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './teacher-list.component.html',
  styleUrl: './teacher-list.component.css'
})
export class TeacherListComponent implements OnInit {
teachersList:any;

constructor(private http:HttpClient){

}

ngOnInit(): void {
  this.loadData();
}

loadData(){

  this.http.get("http://localhost:8080/teacher",{observe:"response"}).subscribe(({body})=>{
    this.teachersList = body;
    console.log(body)
  })
}



}
