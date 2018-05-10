/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ClinicTestModule } from '../../../test.module';
import { PetMySuffixComponent } from '../../../../../../main/webapp/app/entities/pet-my-suffix/pet-my-suffix.component';
import { PetMySuffixService } from '../../../../../../main/webapp/app/entities/pet-my-suffix/pet-my-suffix.service';
import { PetMySuffix } from '../../../../../../main/webapp/app/entities/pet-my-suffix/pet-my-suffix.model';

describe('Component Tests', () => {

    describe('PetMySuffix Management Component', () => {
        let comp: PetMySuffixComponent;
        let fixture: ComponentFixture<PetMySuffixComponent>;
        let service: PetMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [PetMySuffixComponent],
                providers: [
                    PetMySuffixService
                ]
            })
            .overrideTemplate(PetMySuffixComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PetMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PetMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new PetMySuffix(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.pets[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
