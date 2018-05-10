import { BaseEntity } from './../../shared';

export class OwnerMySuffix implements BaseEntity {
    constructor(
        public id?: number,
        public firstName?: string,
        public lastName?: string,
        public address?: string,
        public city?: string,
        public telephone?: string,
        public homePage?: string,
        public email?: string,
        public birthDate?: string,
        public pet?: BaseEntity,
    ) {
    }
}
