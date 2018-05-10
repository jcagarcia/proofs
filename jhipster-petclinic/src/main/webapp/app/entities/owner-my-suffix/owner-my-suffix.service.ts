import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { OwnerMySuffix } from './owner-my-suffix.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<OwnerMySuffix>;

@Injectable()
export class OwnerMySuffixService {

    private resourceUrl =  SERVER_API_URL + 'api/owners';

    constructor(private http: HttpClient) { }

    create(owner: OwnerMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(owner);
        return this.http.post<OwnerMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(owner: OwnerMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(owner);
        return this.http.put<OwnerMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<OwnerMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<OwnerMySuffix[]>> {
        const options = createRequestOption(req);
        return this.http.get<OwnerMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<OwnerMySuffix[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: OwnerMySuffix = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<OwnerMySuffix[]>): HttpResponse<OwnerMySuffix[]> {
        const jsonResponse: OwnerMySuffix[] = res.body;
        const body: OwnerMySuffix[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to OwnerMySuffix.
     */
    private convertItemFromServer(owner: OwnerMySuffix): OwnerMySuffix {
        const copy: OwnerMySuffix = Object.assign({}, owner);
        return copy;
    }

    /**
     * Convert a OwnerMySuffix to a JSON which can be sent to the server.
     */
    private convert(owner: OwnerMySuffix): OwnerMySuffix {
        const copy: OwnerMySuffix = Object.assign({}, owner);
        return copy;
    }
}
