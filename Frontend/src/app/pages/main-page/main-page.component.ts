import { NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { AppService } from '../../services/app.service';

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [RouterLink,NgIf],
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css',
  providers:[AppService]
})
export class MainPageComponent implements OnInit {
@Input() userRole!:any;

constructor(private http:HttpClient,private service:AppService){}

ngOnInit(): void {
  this.userRole = this.service.getRole();
}

}
