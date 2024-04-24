import { NgFor, NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-subject-overview',
  standalone: true,
  imports: [
    NgFor,RouterLink,NgIf
  ],
  templateUrl: './subject-overview.component.html',
  styleUrl: './subject-overview.component.css'
})
export class SubjectOverviewComponent {

  subjectList:any;
  
  constructor(private http:HttpClient){
  
  }
  
  ngOnInit(): void {
    this.loadData();
  }
  
  loadData(){
  
    this.http.get("http://localhost:8080/subject",{observe:"response"}).subscribe(({body})=>{
      this.subjectList = body;
      console.log(body)
    })
  }

}
