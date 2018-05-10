import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { VisitMySuffix } from './visit-my-suffix.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<VisitMySuffix>;

@Injectable()
export class VisitMySuffixService {

    private resourceUrl =  SERVER_API_URL + 'api/visits';

    constructor(private http: HttpClient) { }

    create(visit: VisitMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(visit);
        return this.http.post<VisitMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(visit: VisitMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(visit);
        return this.http.put<VisitMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<VisitMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<VisitMySuffix[]>> {
        const options = createRequestOption(req);
        return this.http.get<VisitMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<VisitMySuffix[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: VisitMySuffix = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<VisitMySuffix[]>): HttpResponse<VisitMySuffix[]> {
        const jsonResponse: VisitMySuffix[] = res.body;
        const body: VisitMySuffix[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to VisitMySuffix.
     */
    private convertItemFromServer(visit: VisitMySuffix): VisitMySuffix {
        const copy: VisitMySuffix = Object.assign({}, visit);
        return copy;
    }

    /**
     * Convert a VisitMySuffix to a JSON which can be sent to the server.
     */
    private convert(visit: VisitMySuffix): VisitMySuffix {
        const copy: VisitMySuffix = Object.assign({}, visit);
        return copy;
    }
}
