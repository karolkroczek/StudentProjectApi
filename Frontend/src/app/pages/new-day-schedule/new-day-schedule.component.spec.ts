import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewDayScheduleComponent } from './new-day-schedule.component';

describe('NewDayScheduleComponent', () => {
  let component: NewDayScheduleComponent;
  let fixture: ComponentFixture<NewDayScheduleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewDayScheduleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewDayScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
