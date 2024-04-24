import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstRunPageComponent } from './first-run-page.component';

describe('FirstRunPageComponent', () => {
  let component: FirstRunPageComponent;
  let fixture: ComponentFixture<FirstRunPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FirstRunPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FirstRunPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
