import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { VisitMySuffix } from './visit-my-suffix.model';
import { VisitMySuffixService } from './visit-my-suffix.service';

@Component({
    selector: 'jhi-visit-my-suffix-detail',
    templateUrl: './visit-my-suffix-detail.component.html'
})
export class VisitMySuffixDetailComponent implements OnInit, OnDestroy {

    visit: VisitMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private visitService: VisitMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInVisits();
    }

    load(id) {
        this.visitService.find(id)
            .subscribe((visitResponse: HttpResponse<VisitMySuffix>) => {
                this.visit = visitResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInVisits() {
        this.eventSubscriber = this.eventManager.subscribe(
            'visitListModification',
            (response) => this.load(this.visit.id)
        );
    }
}
