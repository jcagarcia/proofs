import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { OwnerMySuffix } from './owner-my-suffix.model';
import { OwnerMySuffixService } from './owner-my-suffix.service';

@Component({
    selector: 'jhi-owner-my-suffix-detail',
    templateUrl: './owner-my-suffix-detail.component.html'
})
export class OwnerMySuffixDetailComponent implements OnInit, OnDestroy {

    owner: OwnerMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private ownerService: OwnerMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInOwners();
    }

    load(id) {
        this.ownerService.find(id)
            .subscribe((ownerResponse: HttpResponse<OwnerMySuffix>) => {
                this.owner = ownerResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInOwners() {
        this.eventSubscriber = this.eventManager.subscribe(
            'ownerListModification',
            (response) => this.load(this.owner.id)
        );
    }
}
