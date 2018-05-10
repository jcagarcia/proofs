/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { ClinicTestModule } from '../../../test.module';
import { VetMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix-detail.component';
import { VetMySuffixService } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix.service';
import { VetMySuffix } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix.model';

describe('Component Tests', () => {

    describe('VetMySuffix Management Detail Component', () => {
        let comp: VetMySuffixDetailComponent;
        let fixture: ComponentFixture<VetMySuffixDetailComponent>;
        let service: VetMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [VetMySuffixDetailComponent],
                providers: [
                    VetMySuffixService
                ]
            })
            .overrideTemplate(VetMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VetMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VetMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new VetMySuffix(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.vet).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
