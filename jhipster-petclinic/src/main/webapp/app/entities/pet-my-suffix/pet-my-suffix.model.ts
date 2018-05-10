import { BaseEntity } from './../../shared';

export const enum PetType {
    'DIG',
    'CAT',
    'BIRD'
}

export class PetMySuffix implements BaseEntity {
    constructor(
        public id?: number,
        public sendReminders?: boolean,
        public name?: string,
        public weight?: number,
        public petType?: PetType,
        public owners?: BaseEntity[],
        public visit?: BaseEntity,
    ) {
        this.sendReminders = false;
    }
}
