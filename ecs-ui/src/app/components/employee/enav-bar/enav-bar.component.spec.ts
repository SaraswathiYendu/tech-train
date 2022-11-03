import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnavBarComponent } from './enav-bar.component';

describe('EnavBarComponent', () => {
  let component: EnavBarComponent;
  let fixture: ComponentFixture<EnavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnavBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
