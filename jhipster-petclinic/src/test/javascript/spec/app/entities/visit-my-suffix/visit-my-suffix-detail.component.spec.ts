/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { ClinicTestModule } from '../../../test.module';
import { VisitMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/visit-my-suffix/visit-my-suffix-detail.component';
import { VisitMySuffixService } from '../../../../../../main/webapp/app/entities/visit-my-suffix/visit-my-suffix.service';
import { VisitMySuffix } from '../../../../../../main/webapp/app/entities/visit-my-suffix/visit-my-suffix.model';

describe('Component Tests', () => {

    describe('VisitMySuffix Management Detail Component', () => {
        let comp: VisitMySuffixDetailComponent;
        let fixture: ComponentFixture<VisitMySuffixDetailComponent>;
        let service: VisitMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [VisitMySuffixDetailComponent],
                providers: [
                    VisitMySuffixService
                ]
            })
            .overrideTemplate(VisitMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VisitMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VisitMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new VisitMySuffix(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.visit).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
