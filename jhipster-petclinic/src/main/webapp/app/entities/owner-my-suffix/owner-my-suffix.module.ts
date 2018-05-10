import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ClinicSharedModule } from '../../shared';
import {
    OwnerMySuffixService,
    OwnerMySuffixPopupService,
    OwnerMySuffixComponent,
    OwnerMySuffixDetailComponent,
    OwnerMySuffixDialogComponent,
    OwnerMySuffixPopupComponent,
    OwnerMySuffixDeletePopupComponent,
    OwnerMySuffixDeleteDialogComponent,
    ownerRoute,
    ownerPopupRoute,
} from './';

const ENTITY_STATES = [
    ...ownerRoute,
    ...ownerPopupRoute,
];

@NgModule({
    imports: [
        ClinicSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        OwnerMySuffixComponent,
        OwnerMySuffixDetailComponent,
        OwnerMySuffixDialogComponent,
        OwnerMySuffixDeleteDialogComponent,
        OwnerMySuffixPopupComponent,
        OwnerMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        OwnerMySuffixComponent,
        OwnerMySuffixDialogComponent,
        OwnerMySuffixPopupComponent,
        OwnerMySuffixDeleteDialogComponent,
        OwnerMySuffixDeletePopupComponent,
    ],
    providers: [
        OwnerMySuffixService,
        OwnerMySuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ClinicOwnerMySuffixModule {}
