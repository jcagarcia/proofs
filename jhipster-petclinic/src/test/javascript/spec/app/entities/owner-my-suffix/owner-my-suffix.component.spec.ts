/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ClinicTestModule } from '../../../test.module';
import { OwnerMySuffixComponent } from '../../../../../../main/webapp/app/entities/owner-my-suffix/owner-my-suffix.component';
import { OwnerMySuffixService } from '../../../../../../main/webapp/app/entities/owner-my-suffix/owner-my-suffix.service';
import { OwnerMySuffix } from '../../../../../../main/webapp/app/entities/owner-my-suffix/owner-my-suffix.model';

describe('Component Tests', () => {

    describe('OwnerMySuffix Management Component', () => {
        let comp: OwnerMySuffixComponent;
        let fixture: ComponentFixture<OwnerMySuffixComponent>;
        let service: OwnerMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [OwnerMySuffixComponent],
                providers: [
                    OwnerMySuffixService
                ]
            })
            .overrideTemplate(OwnerMySuffixComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(OwnerMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(OwnerMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new OwnerMySuffix(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.owners[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
