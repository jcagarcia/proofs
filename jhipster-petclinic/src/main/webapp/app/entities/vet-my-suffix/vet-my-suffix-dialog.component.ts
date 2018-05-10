import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { VetMySuffix } from './vet-my-suffix.model';
import { VetMySuffixPopupService } from './vet-my-suffix-popup.service';
import { VetMySuffixService } from './vet-my-suffix.service';
import { VisitMySuffix, VisitMySuffixService } from '../visit-my-suffix';

@Component({
    selector: 'jhi-vet-my-suffix-dialog',
    templateUrl: './vet-my-suffix-dialog.component.html'
})
export class VetMySuffixDialogComponent implements OnInit {

    vet: VetMySuffix;
    isSaving: boolean;

    visits: VisitMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private vetService: VetMySuffixService,
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
        if (this.vet.id !== undefined) {
            this.subscribeToSaveResponse(
                this.vetService.update(this.vet));
        } else {
            this.subscribeToSaveResponse(
                this.vetService.create(this.vet));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<VetMySuffix>>) {
        result.subscribe((res: HttpResponse<VetMySuffix>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: VetMySuffix) {
        this.eventManager.broadcast({ name: 'vetListModification', content: 'OK'});
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
    selector: 'jhi-vet-my-suffix-popup',
    template: ''
})
export class VetMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vetPopupService: VetMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.vetPopupService
                    .open(VetMySuffixDialogComponent as Component, params['id']);
            } else {
                this.vetPopupService
                    .open(VetMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
