import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VisitMySuffix } from './visit-my-suffix.model';
import { VisitMySuffixPopupService } from './visit-my-suffix-popup.service';
import { VisitMySuffixService } from './visit-my-suffix.service';

@Component({
    selector: 'jhi-visit-my-suffix-delete-dialog',
    templateUrl: './visit-my-suffix-delete-dialog.component.html'
})
export class VisitMySuffixDeleteDialogComponent {

    visit: VisitMySuffix;

    constructor(
        private visitService: VisitMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.visitService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'visitListModification',
                content: 'Deleted an visit'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-visit-my-suffix-delete-popup',
    template: ''
})
export class VisitMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private visitPopupService: VisitMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.visitPopupService
                .open(VisitMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
