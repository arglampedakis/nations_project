import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalyticTableHomeComponent } from './analytic-table-home.component';

describe('AnalyticTableHomeComponent', () => {
  let component: AnalyticTableHomeComponent;
  let fixture: ComponentFixture<AnalyticTableHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnalyticTableHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnalyticTableHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
