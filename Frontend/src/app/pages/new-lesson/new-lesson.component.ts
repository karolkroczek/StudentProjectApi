import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-new-lesson',
  standalone: true,
  imports: [RouterLink,ReactiveFormsModule],
  templateUrl: './new-lesson.component.html',
  styleUrl: './new-lesson.component.css'
})
export class NewLessonComponent {
@Input({required:false}) subject:string | any;

formGroup = new FormGroup({
  name: new FormControl(),
  description: new FormControl(),
  frequency: new FormControl(), //tutaj bedzie ID do tabeli z frekwencja z cookies
});

handleSubmit(){
  console.log(this.formGroup.value); //po wykonaniu zapytania trzeba zrobic wyczysczenie cookies
}

}
