/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { ClinicTestModule } from '../../../test.module';
import { OwnerMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/owner-my-suffix/owner-my-suffix-detail.component';
import { OwnerMySuffixService } from '../../../../../../main/webapp/app/entities/owner-my-suffix/owner-my-suffix.service';
import { OwnerMySuffix } from '../../../../../../main/webapp/app/entities/owner-my-suffix/owner-my-suffix.model';

describe('Component Tests', () => {

    describe('OwnerMySuffix Management Detail Component', () => {
        let comp: OwnerMySuffixDetailComponent;
        let fixture: ComponentFixture<OwnerMySuffixDetailComponent>;
        let service: OwnerMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [OwnerMySuffixDetailComponent],
                providers: [
                    OwnerMySuffixService
                ]
            })
            .overrideTemplate(OwnerMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(OwnerMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(OwnerMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new OwnerMySuffix(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.owner).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
