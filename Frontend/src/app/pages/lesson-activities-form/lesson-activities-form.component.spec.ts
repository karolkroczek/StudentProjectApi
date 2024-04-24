import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LessonActivitiesFormComponent } from './lesson-activities-form.component';

describe('LessonActivitiesFormComponent', () => {
  let component: LessonActivitiesFormComponent;
  let fixture: ComponentFixture<LessonActivitiesFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LessonActivitiesFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LessonActivitiesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
