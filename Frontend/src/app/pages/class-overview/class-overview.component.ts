import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-class-overview',
  standalone: true,
  imports: [RouterLink,NgFor],
  templateUrl: './class-overview.component.html',
  styleUrl: './class-overview.component.css'
})
export class ClassOverviewComponent implements OnInit {

classList:any;

  constructor(private http:HttpClient){}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
    this.http.get("http://localhost:8080/SchoolClass/all",{}).subscribe((res)=>{
      console.log(res)
      this.classList = res;
    })
  }

}
