import { NgIf } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-modal',
  standalone: true,
  imports: [NgIf],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent implements OnInit {
 display:boolean = true;
 basicOutput:boolean = true
 @Input({required:false}) displayText: any;
 @Input({required:false}) specialText: any;

ngOnInit(){
  console.log(this.specialText);
  if(this.displayText == true){
  this.basicOutput = false;
  }
}

}
