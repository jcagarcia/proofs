import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { PetMySuffix } from './pet-my-suffix.model';
import { PetMySuffixService } from './pet-my-suffix.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-pet-my-suffix',
    templateUrl: './pet-my-suffix.component.html'
})
export class PetMySuffixComponent implements OnInit, OnDestroy {
pets: PetMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private petService: PetMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.petService.query().subscribe(
            (res: HttpResponse<PetMySuffix[]>) => {
                this.pets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInPets();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: PetMySuffix) {
        return item.id;
    }
    registerChangeInPets() {
        this.eventSubscriber = this.eventManager.subscribe('petListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
