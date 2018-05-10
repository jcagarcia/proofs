import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ClinicPetMySuffixModule } from './pet-my-suffix/pet-my-suffix.module';
import { ClinicOwnerMySuffixModule } from './owner-my-suffix/owner-my-suffix.module';
import { ClinicVetMySuffixModule } from './vet-my-suffix/vet-my-suffix.module';
import { ClinicVisitMySuffixModule } from './visit-my-suffix/visit-my-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        ClinicPetMySuffixModule,
        ClinicOwnerMySuffixModule,
        ClinicVetMySuffixModule,
        ClinicVisitMySuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ClinicEntityModule {}
