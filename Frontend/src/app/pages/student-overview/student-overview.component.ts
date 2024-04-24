import { NgIf } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';

enum listVars{
  GRADES = "GRADES",
  FREQUENCY = "FREQUENCY",
  NOTE = "NOTE"
}

type listTypes = keyof typeof listVars;

@Component({
  selector: 'app-student-overview',
  standalone: true,
  imports: [NgIf,RouterLink],
  templateUrl: './student-overview.component.html',
  styleUrl: './student-overview.component.css'
})
export class StudentOverviewComponent implements OnInit {
@Input({required:true}) className! :string;
@Input({required:true}) listType! :listTypes;

constructor(private activatedRoute:ActivatedRoute){

}
ngOnInit(){
    this.activatedRoute.params.subscribe(
        res=>{
          console.log(res);
          this.className = res['id'];
          
        }
    ).unsubscribe();
    this.activatedRoute.data.subscribe(
      res=>{
        this.listType = res['listType'];
      }
    )
}

loadData(){
  
}

}
