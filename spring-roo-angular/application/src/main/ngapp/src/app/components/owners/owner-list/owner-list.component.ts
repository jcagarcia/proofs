import {Component, OnInit} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {OwnerService} from '../../../services/owner/owner.service';
import {DeleteConfirmDialogComponent} from "../../delete-confirm-dialog/delete-confirm-dialog.component";

@Component({
    selector: 'app-owner-list',
    templateUrl: './owner-list.component.html',
    styleUrls: ['./owner-list.component.css']
})
export class OwnerListComponent implements OnInit {

    // Data
    displayedColumns = ['firstName', 'lastName', 'city', 'telephone', 'tools', 'select'];
    owners: any;
    selectedOwners = [];

    // Pagination, sort and search
    resultsLength: number = 0;
    pageIndex: number = 0;
    pageSize: number = 5;
    pageSizeOptions = [5, 10, 20]
    sort:string;
    search: string;

    constructor(private ownerService: OwnerService, private deleteDialog: MatDialog) {
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
        this.ownerService.getAll(this.search, this.pageIndex, this.pageSize, this.sort).subscribe(data => {
            this.setPagination(data.totalElements, data.number, data.size);
            this.owners = data.content;
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
     * Method that manages the sort event
     * @param event
     */
    onSortChange(event:any){
        if(event.direction == "" || event.active == ""){
            this.sort = "";
        }else{
            this.sort = event.active + "," + event.direction;
        }
        this.loadData();
    }

    /**
     * Public event that manages the filter input change
     * @param {string} text
     */
    onFilterChange(text: string) {
        this.search = text;
        this.loadData();
    }

    /**
     * Public event that manages the click on the delete button
     *
     * @param {number} id
     */
    onClickDelete(id: number) {
        this.ownerService.remove(id).subscribe(data => {
            this.owners = this.loadData();
        });
    }

    /**
     * Function to delete in batch all the selected items
     */
    onClickDeleteInBatch() {
        if(this.selectedOwners.length > 0){
            let confirm = false;
            let dialogRef = this.deleteDialog.open(DeleteConfirmDialogComponent, {
                height: '200px',
                width: '500px',
            });
            dialogRef.afterClosed().subscribe(result => {
                if(result){
                    this.ownerService.removeAll(this.selectedOwners).subscribe(data => {
                        this.owners = this.loadData();
                        this.selectedOwners = [];
                    });
                }
            });
        }
    }

    /**
     * Public event that saves the change in the checkboxes elements
     *
     * @param event
     * @param row
     */
    onSelectOrDeselectRow(event:any, row:any){
        if(event.checked){
            this.selectedOwners.push(row.id);
        }else{
            var index =  this.selectedOwners.indexOf(row.id, 0);
            if (index > -1) {
                this.selectedOwners.splice(index, 1);
            }
        }
    }

}
