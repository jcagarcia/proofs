import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ClinicSharedModule } from '../../shared';
import {
    VetMySuffixService,
    VetMySuffixPopupService,
    VetMySuffixComponent,
    VetMySuffixDetailComponent,
    VetMySuffixDialogComponent,
    VetMySuffixPopupComponent,
    VetMySuffixDeletePopupComponent,
    VetMySuffixDeleteDialogComponent,
    vetRoute,
    vetPopupRoute,
} from './';

const ENTITY_STATES = [
    ...vetRoute,
    ...vetPopupRoute,
];

@NgModule({
    imports: [
        ClinicSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        VetMySuffixComponent,
        VetMySuffixDetailComponent,
        VetMySuffixDialogComponent,
        VetMySuffixDeleteDialogComponent,
        VetMySuffixPopupComponent,
        VetMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        VetMySuffixComponent,
        VetMySuffixDialogComponent,
        VetMySuffixPopupComponent,
        VetMySuffixDeleteDialogComponent,
        VetMySuffixDeletePopupComponent,
    ],
    providers: [
        VetMySuffixService,
        VetMySuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ClinicVetMySuffixModule {}
