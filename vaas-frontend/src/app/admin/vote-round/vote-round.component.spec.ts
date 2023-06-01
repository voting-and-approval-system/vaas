import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoteRoundComponent } from './vote-round.component';

describe('VoteRoundComponent', () => {
  let component: VoteRoundComponent;
  let fixture: ComponentFixture<VoteRoundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoteRoundComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VoteRoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
