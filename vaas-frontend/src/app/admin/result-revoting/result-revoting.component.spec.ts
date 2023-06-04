import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultRevotingComponent } from './result-revoting.component';

describe('ResultRevotingComponent', () => {
  let component: ResultRevotingComponent;
  let fixture: ComponentFixture<ResultRevotingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResultRevotingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResultRevotingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
