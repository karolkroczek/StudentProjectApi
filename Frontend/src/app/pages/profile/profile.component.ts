import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css',
  providers:[
    AppService
  ]
})
export class ProfileComponent implements OnInit {
@Input({required:true}) userId! :any;

userInfo:any = {};

constructor(private activatedRoute:ActivatedRoute,private service:AppService){
  this.activatedRoute.data.subscribe(
    res=>{
      this.userId = res['userId'];
    }
  )
}
ngOnInit(): void {
   this.userInfo = this.service.getCookie('userInfo');
   this.userInfo = JSON.parse(this.userInfo);
   this.userInfo = this.userInfo.userInfo;
   console.log(this.userInfo)
}

}