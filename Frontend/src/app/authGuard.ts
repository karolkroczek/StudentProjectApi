import { ActivatedRouteSnapshot, CanActivateFn, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AppService } from "./services/app.service";

export const AuthGurad:CanActivateFn=(route:ActivatedRouteSnapshot,state:RouterStateSnapshot):Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree=>{ 
    return !AppService.logged;

};
