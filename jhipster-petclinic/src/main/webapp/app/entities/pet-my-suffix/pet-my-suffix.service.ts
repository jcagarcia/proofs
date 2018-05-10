import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { PetMySuffix } from './pet-my-suffix.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<PetMySuffix>;

@Injectable()
export class PetMySuffixService {

    private resourceUrl =  SERVER_API_URL + 'api/pets';

    constructor(private http: HttpClient) { }

    create(pet: PetMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(pet);
        return this.http.post<PetMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(pet: PetMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(pet);
        return this.http.put<PetMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<PetMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<PetMySuffix[]>> {
        const options = createRequestOption(req);
        return this.http.get<PetMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<PetMySuffix[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: PetMySuffix = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<PetMySuffix[]>): HttpResponse<PetMySuffix[]> {
        const jsonResponse: PetMySuffix[] = res.body;
        const body: PetMySuffix[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to PetMySuffix.
     */
    private convertItemFromServer(pet: PetMySuffix): PetMySuffix {
        const copy: PetMySuffix = Object.assign({}, pet);
        return copy;
    }

    /**
     * Convert a PetMySuffix to a JSON which can be sent to the server.
     */
    private convert(pet: PetMySuffix): PetMySuffix {
        const copy: PetMySuffix = Object.assign({}, pet);
        return copy;
    }
}
