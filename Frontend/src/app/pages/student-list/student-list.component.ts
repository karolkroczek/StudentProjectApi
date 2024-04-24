import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [NgFor,RouterLink],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent implements OnInit {
  studentsList:any;
  
  constructor(private http:HttpClient){
  
  }
  
  ngOnInit(): void {
    this.loadData();
  }
  
  loadData(){
  
    this.http.get("http://localhost:8080/student",{observe:"response"}).subscribe(({body})=>{
      this.studentsList = body;
      console.log(body)
    })
  }
  
  
  
}
