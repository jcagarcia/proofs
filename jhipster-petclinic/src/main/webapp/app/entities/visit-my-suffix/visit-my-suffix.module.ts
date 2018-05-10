import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ClinicSharedModule } from '../../shared';
import {
    VisitMySuffixService,
    VisitMySuffixPopupService,
    VisitMySuffixComponent,
    VisitMySuffixDetailComponent,
    VisitMySuffixDialogComponent,
    VisitMySuffixPopupComponent,
    VisitMySuffixDeletePopupComponent,
    VisitMySuffixDeleteDialogComponent,
    visitRoute,
    visitPopupRoute,
} from './';

const ENTITY_STATES = [
    ...visitRoute,
    ...visitPopupRoute,
];

@NgModule({
    imports: [
        ClinicSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        VisitMySuffixComponent,
        VisitMySuffixDetailComponent,
        VisitMySuffixDialogComponent,
        VisitMySuffixDeleteDialogComponent,
        VisitMySuffixPopupComponent,
        VisitMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        VisitMySuffixComponent,
        VisitMySuffixDialogComponent,
        VisitMySuffixPopupComponent,
        VisitMySuffixDeleteDialogComponent,
        VisitMySuffixDeletePopupComponent,
    ],
    providers: [
        VisitMySuffixService,
        VisitMySuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ClinicVisitMySuffixModule {}
