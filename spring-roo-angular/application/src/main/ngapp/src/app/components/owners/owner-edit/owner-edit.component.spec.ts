import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerEditComponent } from './owner-edit.component';

describe('OwnerEditComponent', () => {
  let component: OwnerEditComponent;
  let fixture: ComponentFixture<OwnerEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
