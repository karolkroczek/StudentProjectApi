import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewSchoolClassComponent } from './new-school-class.component';

describe('NewSchoolClassComponent', () => {
  let component: NewSchoolClassComponent;
  let fixture: ComponentFixture<NewSchoolClassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewSchoolClassComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewSchoolClassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
