import { BaseEntity } from './../../shared';

export class VisitMySuffix implements BaseEntity {
    constructor(
        public id?: number,
        public description?: string,
        public visitDate?: string,
        public pets?: BaseEntity[],
        public vets?: BaseEntity[],
    ) {
    }
}
