import { Component, OnInit } from '@angular/core';

import { PetService } from '../shared/pet/pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.css']
})
export class PetListComponent implements OnInit {
  pets: Array<any>;

  constructor(private petService: PetService) { }

  ngOnInit() {
    this.petService.getAll().subscribe(data => {
      this.pets = data;
    });
  }

}
