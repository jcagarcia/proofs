import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { OwnerMySuffixComponent } from './owner-my-suffix.component';
import { OwnerMySuffixDetailComponent } from './owner-my-suffix-detail.component';
import { OwnerMySuffixPopupComponent } from './owner-my-suffix-dialog.component';
import { OwnerMySuffixDeletePopupComponent } from './owner-my-suffix-delete-dialog.component';

export const ownerRoute: Routes = [
    {
        path: 'owner-my-suffix',
        component: OwnerMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.owner.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'owner-my-suffix/:id',
        component: OwnerMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.owner.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const ownerPopupRoute: Routes = [
    {
        path: 'owner-my-suffix-new',
        component: OwnerMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.owner.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'owner-my-suffix/:id/edit',
        component: OwnerMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.owner.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'owner-my-suffix/:id/delete',
        component: OwnerMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.owner.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
