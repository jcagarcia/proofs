import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { PetMySuffix } from './pet-my-suffix.model';
import { PetMySuffixPopupService } from './pet-my-suffix-popup.service';
import { PetMySuffixService } from './pet-my-suffix.service';
import { VisitMySuffix, VisitMySuffixService } from '../visit-my-suffix';

@Component({
    selector: 'jhi-pet-my-suffix-dialog',
    templateUrl: './pet-my-suffix-dialog.component.html'
})
export class PetMySuffixDialogComponent implements OnInit {

    pet: PetMySuffix;
    isSaving: boolean;

    visits: VisitMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private petService: PetMySuffixService,
        private visitService: VisitMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.visitService.query()
            .subscribe((res: HttpResponse<VisitMySuffix[]>) => { this.visits = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.pet.id !== undefined) {
            this.subscribeToSaveResponse(
                this.petService.update(this.pet));
        } else {
            this.subscribeToSaveResponse(
                this.petService.create(this.pet));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<PetMySuffix>>) {
        result.subscribe((res: HttpResponse<PetMySuffix>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: PetMySuffix) {
        this.eventManager.broadcast({ name: 'petListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackVisitById(index: number, item: VisitMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-pet-my-suffix-popup',
    template: ''
})
export class PetMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private petPopupService: PetMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.petPopupService
                    .open(PetMySuffixDialogComponent as Component, params['id']);
            } else {
                this.petPopupService
                    .open(PetMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
