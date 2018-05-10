import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { VetMySuffixComponent } from './vet-my-suffix.component';
import { VetMySuffixDetailComponent } from './vet-my-suffix-detail.component';
import { VetMySuffixPopupComponent } from './vet-my-suffix-dialog.component';
import { VetMySuffixDeletePopupComponent } from './vet-my-suffix-delete-dialog.component';

export const vetRoute: Routes = [
    {
        path: 'vet-my-suffix',
        component: VetMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.vet.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'vet-my-suffix/:id',
        component: VetMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.vet.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const vetPopupRoute: Routes = [
    {
        path: 'vet-my-suffix-new',
        component: VetMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.vet.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'vet-my-suffix/:id/edit',
        component: VetMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.vet.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'vet-my-suffix/:id/delete',
        component: VetMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.vet.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
