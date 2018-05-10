import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PetMySuffixComponent } from './pet-my-suffix.component';
import { PetMySuffixDetailComponent } from './pet-my-suffix-detail.component';
import { PetMySuffixPopupComponent } from './pet-my-suffix-dialog.component';
import { PetMySuffixDeletePopupComponent } from './pet-my-suffix-delete-dialog.component';

export const petRoute: Routes = [
    {
        path: 'pet-my-suffix',
        component: PetMySuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.pet.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'pet-my-suffix/:id',
        component: PetMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.pet.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const petPopupRoute: Routes = [
    {
        path: 'pet-my-suffix-new',
        component: PetMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.pet.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'pet-my-suffix/:id/edit',
        component: PetMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.pet.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'pet-my-suffix/:id/delete',
        component: PetMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'clinicApp.pet.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
