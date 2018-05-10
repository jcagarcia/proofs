import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { PetMySuffix } from './pet-my-suffix.model';
import { PetMySuffixService } from './pet-my-suffix.service';

@Component({
    selector: 'jhi-pet-my-suffix-detail',
    templateUrl: './pet-my-suffix-detail.component.html'
})
export class PetMySuffixDetailComponent implements OnInit, OnDestroy {

    pet: PetMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private petService: PetMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInPets();
    }

    load(id) {
        this.petService.find(id)
            .subscribe((petResponse: HttpResponse<PetMySuffix>) => {
                this.pet = petResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInPets() {
        this.eventSubscriber = this.eventManager.subscribe(
            'petListModification',
            (response) => this.load(this.pet.id)
        );
    }
}
