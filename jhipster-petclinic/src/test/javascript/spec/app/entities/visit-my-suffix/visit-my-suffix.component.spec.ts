/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ClinicTestModule } from '../../../test.module';
import { VisitMySuffixComponent } from '../../../../../../main/webapp/app/entities/visit-my-suffix/visit-my-suffix.component';
import { VisitMySuffixService } from '../../../../../../main/webapp/app/entities/visit-my-suffix/visit-my-suffix.service';
import { VisitMySuffix } from '../../../../../../main/webapp/app/entities/visit-my-suffix/visit-my-suffix.model';

describe('Component Tests', () => {

    describe('VisitMySuffix Management Component', () => {
        let comp: VisitMySuffixComponent;
        let fixture: ComponentFixture<VisitMySuffixComponent>;
        let service: VisitMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [VisitMySuffixComponent],
                providers: [
                    VisitMySuffixService
                ]
            })
            .overrideTemplate(VisitMySuffixComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VisitMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VisitMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new VisitMySuffix(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.visits[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
