import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { PetMySuffix } from './pet-my-suffix.model';
import { PetMySuffixPopupService } from './pet-my-suffix-popup.service';
import { PetMySuffixService } from './pet-my-suffix.service';

@Component({
    selector: 'jhi-pet-my-suffix-delete-dialog',
    templateUrl: './pet-my-suffix-delete-dialog.component.html'
})
export class PetMySuffixDeleteDialogComponent {

    pet: PetMySuffix;

    constructor(
        private petService: PetMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.petService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'petListModification',
                content: 'Deleted an pet'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-pet-my-suffix-delete-popup',
    template: ''
})
export class PetMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private petPopupService: PetMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.petPopupService
                .open(PetMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
