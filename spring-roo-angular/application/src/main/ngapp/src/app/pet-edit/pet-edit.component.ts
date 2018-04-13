import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs/Subscription';
import {ActivatedRoute, Router} from '@angular/router';
import {PetService} from '../shared/pet/pet.service';
import {NgForm} from '@angular/forms';

@Component({
    selector: 'app-pet-edit',
    templateUrl: './pet-edit.component.html',
    styleUrls: ['./pet-edit.component.css']
})
export class PetEditComponent implements OnInit {

    pet: any = {};
    petTypes: any = [];

    sub: Subscription;

    constructor(private route: ActivatedRoute,
                private router: Router,
                private petService: PetService) {
    }

    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            const id = params['id'];
            if (id) {
                this.petService.get(id).subscribe((pet: any) => {
                    if (pet) {
                        this.pet = pet;
                    } else {
                        console.log(`Pet with id '${id}' not found, returning to list`);
                        this.gotoList();
                    }
                });
            }
        });

        // Fill the types select
        this.fillTypes();
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    gotoList() {
        this.router.navigate(['/pet-list']);
    }

    save(form: NgForm) {
        this.petService.save(form).subscribe(result => {
            this.gotoList();
        }, error => console.error(error));
    }

    remove(href) {
        this.petService.remove(href).subscribe(result => {
            this.gotoList();
        }, error => console.error(error));
    }

    fillTypes(){
        this.petService.getTypes().subscribe(result => {
            this.petTypes = result;
        }, error => console.error(error));
    }
}
