import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';

@Component({
  selector: 'app-message-view',
  standalone: true,
  imports: [
    RouterLink
  ],
  templateUrl: './message-view.component.html',
  styleUrl: './message-view.component.css'
})
export class MessageViewComponent implements OnInit {

@Input({required:true}) messageId: any;

  constructor(private activatedRoute:ActivatedRoute,private http:HttpClient){}
  currentMessage:any;

  ngOnInit(){
    this.activatedRoute.params.subscribe(res=>{
      this.messageId= res['id'];
      this.loadMessage(this.messageId);
    })
  }

  loadMessage(messageId: any) {
    this.http.get(`http://localhost:8080/message/message?id=${messageId}`,{observe:"response"}).subscribe(res=>{
    this.currentMessage = res.body;
    });
  }
}
