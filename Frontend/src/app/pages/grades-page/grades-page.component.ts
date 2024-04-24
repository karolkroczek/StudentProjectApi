import { Component } from '@angular/core';
import { ModalComponent } from '../../components/modal/modal.component';
import { NgFor, NgIf } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-grades-page',
  standalone: true,
  imports: [ModalComponent,NgIf,NgFor],
  templateUrl: './grades-page.component.html',
  styleUrl: './grades-page.component.css'
})
export class GradesPageComponent {
  moreDetails:boolean = false;
  userId:any;
  marks:any;
  markMoreInfo:any;

  constructor(private activatedRoute: ActivatedRoute,private http:HttpClient){}


  ngOnInit(){
    this.activatedRoute.params.subscribe(res=>{
      this.userId = res['id'];
      this.getUserMarks(this.userId);
    })

  }

  getUserMarks(id:number){
    this.http.get(`http://localhost:8080/marks/student/${id}`,{observe:"response"}).subscribe(res=>{
      this.marks = res.body;
      console.log(this.marks);
    })
  }

  logFunction(text:any){
    this.markMoreInfo = text;
    this.moreDetails = !this.moreDetails;
  }
}
