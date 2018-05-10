import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VetMySuffix } from './vet-my-suffix.model';
import { VetMySuffixPopupService } from './vet-my-suffix-popup.service';
import { VetMySuffixService } from './vet-my-suffix.service';

@Component({
    selector: 'jhi-vet-my-suffix-delete-dialog',
    templateUrl: './vet-my-suffix-delete-dialog.component.html'
})
export class VetMySuffixDeleteDialogComponent {

    vet: VetMySuffix;

    constructor(
        private vetService: VetMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.vetService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'vetListModification',
                content: 'Deleted an vet'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-vet-my-suffix-delete-popup',
    template: ''
})
export class VetMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vetPopupService: VetMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.vetPopupService
                .open(VetMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
