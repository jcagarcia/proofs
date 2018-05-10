import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { OwnerMySuffix } from './owner-my-suffix.model';
import { OwnerMySuffixPopupService } from './owner-my-suffix-popup.service';
import { OwnerMySuffixService } from './owner-my-suffix.service';
import { PetMySuffix, PetMySuffixService } from '../pet-my-suffix';

@Component({
    selector: 'jhi-owner-my-suffix-dialog',
    templateUrl: './owner-my-suffix-dialog.component.html'
})
export class OwnerMySuffixDialogComponent implements OnInit {

    owner: OwnerMySuffix;
    isSaving: boolean;

    pets: PetMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private ownerService: OwnerMySuffixService,
        private petService: PetMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.petService.query()
            .subscribe((res: HttpResponse<PetMySuffix[]>) => { this.pets = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.owner.id !== undefined) {
            this.subscribeToSaveResponse(
                this.ownerService.update(this.owner));
        } else {
            this.subscribeToSaveResponse(
                this.ownerService.create(this.owner));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<OwnerMySuffix>>) {
        result.subscribe((res: HttpResponse<OwnerMySuffix>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: OwnerMySuffix) {
        this.eventManager.broadcast({ name: 'ownerListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackPetById(index: number, item: PetMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-owner-my-suffix-popup',
    template: ''
})
export class OwnerMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private ownerPopupService: OwnerMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.ownerPopupService
                    .open(OwnerMySuffixDialogComponent as Component, params['id']);
            } else {
                this.ownerPopupService
                    .open(OwnerMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
