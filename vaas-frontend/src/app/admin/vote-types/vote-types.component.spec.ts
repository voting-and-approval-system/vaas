import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoteTypesComponent } from './vote-types.component';

describe('VoteTypesComponent', () => {
  let component: VoteTypesComponent;
  let fixture: ComponentFixture<VoteTypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoteTypesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VoteTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
