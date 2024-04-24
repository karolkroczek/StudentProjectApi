import { Injectable } from '@angular/core';

type role = "student"|"teacher"|"director";

type user={
   id:number,
   role:role, 
   name:string, 
   surname:string,
   emailAdress:string
}

@Injectable({
  providedIn: 'root'
})
export class AppService {
   static logged: boolean = false;

   getRole(){
     return  window.sessionStorage.getItem("role")||0;
   }

   getLoggedState(){
      return  window.sessionStorage.getItem("logged")||0;
    }
   
   checkLoggedState(){
      const logged = this.getLoggedState();
      console.log(logged);
      if(logged=="true"){
        return true;
      }else{
        return false;
      }
   }

   getLoggedUserNameAndSurname(){
      return ""
   }

   getLoggedUserInfo(){
      return ""
   }

   public getCookie(cname : string) {
      let name = cname + "=";
      let ca = document.cookie.split(';');
      for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
          c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
          return c.substring(name.length, c.length);
        }
      }
      return "";
    }
    

}
