import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { VetMySuffix } from './vet-my-suffix.model';
import { VetMySuffixService } from './vet-my-suffix.service';

@Component({
    selector: 'jhi-vet-my-suffix-detail',
    templateUrl: './vet-my-suffix-detail.component.html'
})
export class VetMySuffixDetailComponent implements OnInit, OnDestroy {

    vet: VetMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private vetService: VetMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInVets();
    }

    load(id) {
        this.vetService.find(id)
            .subscribe((vetResponse: HttpResponse<VetMySuffix>) => {
                this.vet = vetResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInVets() {
        this.eventSubscriber = this.eventManager.subscribe(
            'vetListModification',
            (response) => this.load(this.vet.id)
        );
    }
}
