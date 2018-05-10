import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { VetMySuffix } from './vet-my-suffix.model';
import { VetMySuffixService } from './vet-my-suffix.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-vet-my-suffix',
    templateUrl: './vet-my-suffix.component.html'
})
export class VetMySuffixComponent implements OnInit, OnDestroy {
vets: VetMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private vetService: VetMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.vetService.query().subscribe(
            (res: HttpResponse<VetMySuffix[]>) => {
                this.vets = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInVets();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: VetMySuffix) {
        return item.id;
    }
    registerChangeInVets() {
        this.eventSubscriber = this.eventManager.subscribe('vetListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
