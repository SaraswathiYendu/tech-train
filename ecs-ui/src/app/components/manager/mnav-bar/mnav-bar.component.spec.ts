import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MnavBarComponent } from './mnav-bar.component';

describe('MnavBarComponent', () => {
  let component: MnavBarComponent;
  let fixture: ComponentFixture<MnavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MnavBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MnavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
