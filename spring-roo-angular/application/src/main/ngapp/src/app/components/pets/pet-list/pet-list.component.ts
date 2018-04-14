import {Component, OnInit} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {PetService} from '../../../services/pet/pet.service';
import {DeleteConfirmDialogComponent} from "../../delete-confirm-dialog/delete-confirm-dialog.component";

@Component({
    selector: 'app-pet-list',
    templateUrl: './pet-list.component.html',
    styleUrls: ['./pet-list.component.css']
})
export class PetListComponent implements OnInit {

    // Data
    displayedColumns = ['name', 'weight', 'type', 'tools', 'select'];
    pets: any;
    selectedPets = [];

    // Pagination
    resultsLength: number = 0;
    pageIndex: number = 0;
    pageSize: number = 5;
    pageSizeOptions = [5, 10, 20]

    // Search
    search: string;

    constructor(private petService: PetService, private deleteDialog: MatDialog) {
    }

    /**
     * On init, load the data with the provided pagination config
     */
    ngOnInit() {
        this.loadData();
    }

    /**
     * Private method used to load the data
     */
    private loadData() {
        this.petService.getAll(this.search, this.pageIndex, this.pageSize).subscribe(data => {
            this.setPagination(data.totalElements, data.number, data.size);
            this.pets = data.content;
        });
    }

    /**
     * Private method used to set the pagination config to the table element
     *
     * @param length
     * @param startIndex
     * @param pageSize
     */
    private setPagination(length, startIndex, pageSize) {
        this.resultsLength = length;
        this.pageIndex = startIndex;
        this.pageSize = pageSize;
    }

    /**
     * Public event that manages the pagination change.
     *
     * @param event
     */
    onPaginateChange(event) {
        this.pageIndex = event.pageIndex;
        this.pageSize = event.pageSize;
        this.loadData();
    }

    /**
     * Public event that manages the click on the delete button
     *
     * @param {number} id
     */
    onClickDelete(id: number) {
        this.petService.remove(id).subscribe(data => {
            this.pets = this.loadData();
        });
    }

    /**
     * Function to delete in batch all the selected items
     */
    onClickDeleteInBatch() {
        if(this.selectedPets.length > 0){
            let confirm = false;
            let dialogRef = this.deleteDialog.open(DeleteConfirmDialogComponent, {
                height: '200px',
                width: '500px',
            });
            dialogRef.afterClosed().subscribe(result => {
                if(result){
                    this.petService.removeAll(this.selectedPets).subscribe(data => {
                        this.pets = this.loadData();
                        this.selectedPets = [];
                    });
                }
            });
        }
    }

    /**
     * Public event that manages the filter input change
     * @param {string} text
     */
    applyFilter(text: string) {
        this.search = text;
        this.loadData();
    }

    /**
     * Public event that saves the change in the checkboxes elements
     *
     * @param event
     * @param row
     */
    onSelectOrDeselectRow(event:any, row:any){
        if(event.checked){
            this.selectedPets.push(row.id);
        }else{
            var index =  this.selectedPets.indexOf(row.id, 0);
            if (index > -1) {
                this.selectedPets.splice(index, 1);
            }
        }
    }

}
