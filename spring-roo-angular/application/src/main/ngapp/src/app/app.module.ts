import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {PetService} from './shared/pet/pet.service';
import {HttpClientModule} from '@angular/common/http';
import {PetListComponent} from './pet-list/pet-list.component';
import {
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatSelectModule,
    MatListModule,
    MatToolbarModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {PetEditComponent} from './pet-edit/pet-edit.component';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';

// Define routes
const appRoutes: Routes = [
    {path: '', redirectTo: '/pet-list', pathMatch: 'full'},
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
        PetListComponent,
        PetEditComponent
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
        MatToolbarModule,
        FormsModule,
        RouterModule.forRoot(appRoutes)
    ],
    providers: [PetService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
