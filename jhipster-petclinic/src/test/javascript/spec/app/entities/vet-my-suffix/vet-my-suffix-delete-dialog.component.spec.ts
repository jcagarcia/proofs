/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { ClinicTestModule } from '../../../test.module';
import { VetMySuffixDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix-delete-dialog.component';
import { VetMySuffixService } from '../../../../../../main/webapp/app/entities/vet-my-suffix/vet-my-suffix.service';

describe('Component Tests', () => {

    describe('VetMySuffix Management Delete Component', () => {
        let comp: VetMySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<VetMySuffixDeleteDialogComponent>;
        let service: VetMySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [ClinicTestModule],
                declarations: [VetMySuffixDeleteDialogComponent],
                providers: [
                    VetMySuffixService
                ]
            })
            .overrideTemplate(VetMySuffixDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VetMySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VetMySuffixService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
