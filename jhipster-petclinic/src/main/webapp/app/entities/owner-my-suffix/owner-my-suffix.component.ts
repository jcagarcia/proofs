import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { OwnerMySuffix } from './owner-my-suffix.model';
import { OwnerMySuffixService } from './owner-my-suffix.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-owner-my-suffix',
    templateUrl: './owner-my-suffix.component.html'
})
export class OwnerMySuffixComponent implements OnInit, OnDestroy {
owners: OwnerMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private ownerService: OwnerMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.ownerService.query().subscribe(
            (res: HttpResponse<OwnerMySuffix[]>) => {
                this.owners = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInOwners();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: OwnerMySuffix) {
        return item.id;
    }
    registerChangeInOwners() {
        this.eventSubscriber = this.eventManager.subscribe('ownerListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
