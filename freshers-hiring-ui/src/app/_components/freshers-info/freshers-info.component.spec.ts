import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreshersInfoComponent } from './freshers-info.component';

describe('FreshersInfoComponent', () => {
  let component: FreshersInfoComponent;
  let fixture: ComponentFixture<FreshersInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreshersInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreshersInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
