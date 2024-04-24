import { NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-error',
  standalone: true,
  imports: [NgIf],
  templateUrl: './error.component.html',
  styleUrl: './error.component.css'
})
export class ErrorComponent {
  open : boolean = true;
  @Input({required:false,}) errorMessage :String | undefined;
  handleClick(){
      this.open = !this.open;
  }
}
