import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { VisitMySuffix } from './visit-my-suffix.model';
import { VisitMySuffixService } from './visit-my-suffix.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-visit-my-suffix',
    templateUrl: './visit-my-suffix.component.html'
})
export class VisitMySuffixComponent implements OnInit, OnDestroy {
visits: VisitMySuffix[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private visitService: VisitMySuffixService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.visitService.query().subscribe(
            (res: HttpResponse<VisitMySuffix[]>) => {
                this.visits = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInVisits();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: VisitMySuffix) {
        return item.id;
    }
    registerChangeInVisits() {
        this.eventSubscriber = this.eventManager.subscribe('visitListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
