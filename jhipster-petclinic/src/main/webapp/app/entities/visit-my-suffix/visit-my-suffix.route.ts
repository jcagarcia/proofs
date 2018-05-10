import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { VisitMySuffixComponent } from './visit-my-suffix.component';
import { VisitMySuffixDetailComponent } from './visit-my-suffix-detail.component';
import { VisitMySuffixPopupComponent } from './visit-my-suffix-dialog.component';
import { VisitMySuffixDeletePopupComponent } from './visit-my-suffix-delete-dialog.component';

export const visitRoute: Routes = [
    {
        path: 'visit-my-suffix',
        component: VisitMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.visit.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'visit-my-suffix/:id',
        component: VisitMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.visit.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const visitPopupRoute: Routes = [
    {
        path: 'visit-my-suffix-new',
        component: VisitMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.visit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'visit-my-suffix/:id/edit',
        component: VisitMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.visit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'visit-my-suffix/:id/delete',
        component: VisitMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.visit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
