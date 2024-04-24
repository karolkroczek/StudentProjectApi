import { NgFor } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'app-messages',
  standalone: true,
  imports: [
    RouterLink, NgFor
  ],
  templateUrl: './messages.component.html',
  styleUrl: './messages.component.css',
  providers:[AppService]
})
export class MessagesComponent implements OnInit {
@Input( { required:true }) userId! :string;

recievedMails:any;
userInfo:any;

constructor(private http:HttpClient,private service:AppService){}


ngOnInit(): void {
  this.userInfo =  JSON.parse(this.service.getCookie("userInfo"));
  this.loadData(this.userInfo.emailAddress);
  console.log(this.recievedMails);
}

loadData(id:string){
  this.http.get(`http://localhost:8080/message?email=${id}`).subscribe(res=>{
    this.recievedMails = res;
    console.log(res);
  })
}

}
