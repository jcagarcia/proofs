import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VisitMySuffix } from './visit-my-suffix.model';
import { VisitMySuffixPopupService } from './visit-my-suffix-popup.service';
import { VisitMySuffixService } from './visit-my-suffix.service';

@Component({
    selector: 'jhi-visit-my-suffix-dialog',
    templateUrl: './visit-my-suffix-dialog.component.html'
})
export class VisitMySuffixDialogComponent implements OnInit {

    visit: VisitMySuffix;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private visitService: VisitMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.visit.id !== undefined) {
            this.subscribeToSaveResponse(
                this.visitService.update(this.visit));
        } else {
            this.subscribeToSaveResponse(
                this.visitService.create(this.visit));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<VisitMySuffix>>) {
        result.subscribe((res: HttpResponse<VisitMySuffix>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: VisitMySuffix) {
        this.eventManager.broadcast({ name: 'visitListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-visit-my-suffix-popup',
    template: ''
})
export class VisitMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private visitPopupService: VisitMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.visitPopupService
                    .open(VisitMySuffixDialogComponent as Component, params['id']);
            } else {
                this.visitPopupService
                    .open(VisitMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
