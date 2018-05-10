import { BaseEntity } from './../../shared';

export const enum Speciality {
    'CARDIOLOGY',
    'DENTISTRY',
    'NUTRIOLOGY'
}

export class VetMySuffix implements BaseEntity {
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
        public employeeSince?: string,
        public speciality?: Speciality,
        public visit?: BaseEntity,
    ) {
    }
}
