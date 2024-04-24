import { NgFor, NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ModalComponent } from "../../components/modal/modal.component";
import { AlertComponent } from "../../components/alert/alert.component";
import { ErrorComponent } from "../../components/error/error.component";
import { AppService } from '../../services/app.service';

@Component({
    selector: 'app-new-message',
    standalone: true,
    templateUrl: './new-message.component.html',
    styleUrl: './new-message.component.css',
    imports: [
        ReactiveFormsModule, NgFor,
        ModalComponent,
        AlertComponent, NgIf,
        ErrorComponent
    ],
    providers:[AppService]
})
export class NewMessageComponent implements OnInit {

loadedUsers:boolean = false;


formGroup = new FormGroup({
  to: new FormControl(),
  tittle: new FormControl(),
  content: new FormControl()
})

emailAdressList:any = [];
user:any;
constructor(private http:HttpClient, private service:AppService){

}

ngOnInit(): void {
  console.log(this.user);

  this.http.get("http://localhost:8080/users/mails",{
    observe:"response"
  }).subscribe(({body})=>{
    this.emailAdressList = body;
    console.log(this.emailAdressList)
    this.loadedUsers = true;
  })


}

handleSubmit(){
  const body = {
    from:this.user.emailAdress,
    ...this.formGroup.value
  };
  try{
    this.http.post("http://localhost:8080/message",body,{observe:"response"}).subscribe((res)=>{})
  }catch(e){
    alert("Błąd!");
  }
}
}
