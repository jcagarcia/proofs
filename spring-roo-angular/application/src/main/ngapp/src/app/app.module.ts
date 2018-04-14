import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatSelectModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatCheckboxModule,
    MatListModule,
    MatToolbarModule,
    MatProgressSpinnerModule,
    MatDialogModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';

// Including services
import {PetService} from './services/pet/pet.service';
import {OwnerService} from './services/owner/owner.service';

// Including components
import {HomeComponent} from './components/home/home.component';
import {TopMenuComponent} from './components/top-menu/top-menu.component';
import {DeleteConfirmDialogComponent} from './components/delete-confirm-dialog/delete-confirm-dialog.component';
import {PetListComponent} from './components/pets/pet-list/pet-list.component';
import {PetEditComponent} from './components/pets/pet-edit/pet-edit.component';
import {OwnerListComponent} from './components/owners/owner-list/owner-list.component';
import {OwnerEditComponent} from './components/owners/owner-edit/owner-edit.component';

// Define routes
const appRoutes: Routes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'owner-list',
        component: OwnerListComponent
    },
    {
        path: 'owner-add',
        component: OwnerEditComponent
    },
    {
        path: 'owner-edit/:id',
        component: OwnerEditComponent
    },
    {
        path: 'pet-list',
        component: PetListComponent
    },
    {
        path: 'pet-add',
        component: PetEditComponent
    },
    {
        path: 'pet-edit/:id',
        component: PetEditComponent
    }
];

// Include all the modules, declarations, etc.
@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        TopMenuComponent,
        DeleteConfirmDialogComponent,
        PetListComponent,
        PetEditComponent,
        OwnerListComponent,
        OwnerEditComponent,
    ],
    entryComponents: [
        DeleteConfirmDialogComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MatButtonModule,
        MatCardModule,
        MatInputModule,
        MatSelectModule,
        MatListModule,
        MatTableModule,
        MatPaginatorModule,
        MatSortModule,
        MatCheckboxModule,
        MatToolbarModule,
        MatProgressSpinnerModule,
        MatDialogModule,
        FormsModule,
        RouterModule.forRoot(appRoutes)
    ],
    providers: [
        PetService,
        OwnerService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
