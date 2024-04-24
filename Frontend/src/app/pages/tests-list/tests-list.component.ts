import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tests-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './tests-list.component.html',
  styleUrl: './tests-list.component.css'
})
export class TestsListComponent implements OnInit {
  testList:any;
  
  constructor(private http:HttpClient){
  
  }
  
  ngOnInit(): void {
    this.loadData(1);
  }
  
  loadData(id:number){
  
    this.http.get(`http://localhost:8080/tests/${id}`,{observe:"response"}).subscribe(({body})=>{
      this.testList = body;
      console.log(body)
    })
  }
  
  
}
