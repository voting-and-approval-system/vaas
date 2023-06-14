import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowVotingHistoryComponent } from './show-voting-history.component';

describe('ShowVotingHistoryComponent', () => {
  let component: ShowVotingHistoryComponent;
  let fixture: ComponentFixture<ShowVotingHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowVotingHistoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowVotingHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
