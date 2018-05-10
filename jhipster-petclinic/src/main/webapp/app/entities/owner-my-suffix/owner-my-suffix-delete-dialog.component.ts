import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { OwnerMySuffix } from './owner-my-suffix.model';
import { OwnerMySuffixPopupService } from './owner-my-suffix-popup.service';
import { OwnerMySuffixService } from './owner-my-suffix.service';

@Component({
    selector: 'jhi-owner-my-suffix-delete-dialog',
    templateUrl: './owner-my-suffix-delete-dialog.component.html'
})
export class OwnerMySuffixDeleteDialogComponent {

    owner: OwnerMySuffix;

    constructor(
        private ownerService: OwnerMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.ownerService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'ownerListModification',
                content: 'Deleted an owner'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-owner-my-suffix-delete-popup',
    template: ''
})
export class OwnerMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private ownerPopupService: OwnerMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.ownerPopupService
                .open(OwnerMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
