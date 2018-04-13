import {Component, OnInit} from '@angular/core';
import {PetService} from '../shared/pet/pet.service';

@Component({
    selector: 'app-pet-list',
    templateUrl: './pet-list.component.html',
    styleUrls: ['./pet-list.component.css']
})
export class PetListComponent implements OnInit {

    // Data
    displayedColumns = ['name', 'weight', 'type', 'tools'];
    pets:any;

    // Pagination
    resultsLength:number = 0;
    pageIndex:number = 0;
    pageSize:number = 5;
    pageSizeOptions = [5, 10, 20]

    constructor(private petService: PetService) {
    }

    ngOnInit() {
        this.loadData();
    }

    loadData() {
        this.petService.getAll(this.pageIndex, this.pageSize).subscribe(data => {
            this.setPagination(data.totalElements, data.number, data.size);
            this.pets = data.content;
        });
    }

    setPagination(length, startIndex, pageSize) {
        this.resultsLength = length;
        this.pageIndex = startIndex;
        this.pageSize = pageSize;
    }

    onPaginateChange(event) {
        this.pageIndex = event.pageIndex;
        this.pageSize = event.pageSize;
        this.loadData();
    }

    onClickDelete(id:number){
        this.petService.remove(id).subscribe(data => {
            this.pets = this.loadData();
        });
    }

}
