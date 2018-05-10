/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ClinicTestModule } from '../../../test.module';
import { VetMySuffixComponent } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix.component';
import { VetMySuffixService } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix.service';
import { VetMySuffix } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix.model';

describe('Component Tests', () => {

    describe('VetMySuffix Management Component', () => {
        let comp: VetMySuffixComponent;
        let fixture: ComponentFixture<VetMySuffixComponent>;
        let service: VetMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [VetMySuffixComponent],
                providers: [
                    VetMySuffixService
                ]
            })
            .overrideTemplate(VetMySuffixComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VetMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VetMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new VetMySuffix(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.vets[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
