import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { AppService } from './services/app.service';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive  ],
    providers:[AppService]
})
export class AppComponent implements OnInit {
  title ="Naczosy z sosem";
  service: AppService = new AppService;
  userInfo:any;
  userRole:any;

  constructor(){
  }
  ngOnInit(): void{
    if(this.service.getLoggedState() == 'true'){
      this.userRole = this.service.getRole();
      console.log(this.userRole)
      // this.userInfo = this.service.getCookie("userInfo");
    }else{
    }
  }
  toggleLogged(){
    const logged = this.service.getLoggedState();
    console.log(this.service.getLoggedState());
    if(logged){
      window.sessionStorage.setItem("logged","false");
    }

  }
  getNameAndSurname(){
    return "Użytkownik zalogowany";
  }


  checkState() {
    const logged = this.service.getLoggedState();
    console.log(logged);
    if(logged=="true"){
      return true;
    }else{
      return false;
    }


    const cookieValue = this.service.getCookie('userInfo');
  
    if (cookieValue && cookieValue.trim() !== '') {
      try {
        const val = JSON.parse(cookieValue);
  
        // Sprawdzenie, czy obiekt nie jest pusty
        if (val && Object.entries(val).length > 0) {
          return true;
        } else {
          return false;
        }
      } catch (error) {
        return false;
      }
    } else {
      return false;
    }
  }
  

}

