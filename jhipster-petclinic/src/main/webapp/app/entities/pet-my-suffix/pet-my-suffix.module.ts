import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ClinicSharedModule } from '../../shared';
import {
    PetMySuffixService,
    PetMySuffixPopupService,
    PetMySuffixComponent,
    PetMySuffixDetailComponent,
    PetMySuffixDialogComponent,
    PetMySuffixPopupComponent,
    PetMySuffixDeletePopupComponent,
    PetMySuffixDeleteDialogComponent,
    petRoute,
    petPopupRoute,
} from './';

const ENTITY_STATES = [
    ...petRoute,
    ...petPopupRoute,
];

@NgModule({
    imports: [
        ClinicSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        PetMySuffixComponent,
        PetMySuffixDetailComponent,
        PetMySuffixDialogComponent,
        PetMySuffixDeleteDialogComponent,
        PetMySuffixPopupComponent,
        PetMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        PetMySuffixComponent,
        PetMySuffixDialogComponent,
        PetMySuffixPopupComponent,
        PetMySuffixDeleteDialogComponent,
        PetMySuffixDeletePopupComponent,
    ],
    providers: [
        PetMySuffixService,
        PetMySuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ClinicPetMySuffixModule {}
