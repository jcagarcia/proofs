/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { ClinicTestModule } from '../../../test.module';
import { PetMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/pet-my-suffix/pet-my-suffix-detail.component';
import { PetMySuffixService } from '../../../../../../main/webapp/app/entities/pet-my-suffix/pet-my-suffix.service';
import { PetMySuffix } from '../../../../../../main/webapp/app/entities/pet-my-suffix/pet-my-suffix.model';

describe('Component Tests', () => {

    describe('PetMySuffix Management Detail Component', () => {
        let comp: PetMySuffixDetailComponent;
        let fixture: ComponentFixture<PetMySuffixDetailComponent>;
        let service: PetMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [PetMySuffixDetailComponent],
                providers: [
                    PetMySuffixService
                ]
            })
            .overrideTemplate(PetMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PetMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PetMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new PetMySuffix(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.pet).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
