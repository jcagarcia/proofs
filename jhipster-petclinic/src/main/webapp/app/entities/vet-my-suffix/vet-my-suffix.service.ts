import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { VetMySuffix } from './vet-my-suffix.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<VetMySuffix>;

@Injectable()
export class VetMySuffixService {

    private resourceUrl =  SERVER_API_URL + 'api/vets';

    constructor(private http: HttpClient) { }

    create(vet: VetMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(vet);
        return this.http.post<VetMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(vet: VetMySuffix): Observable<EntityResponseType> {
        const copy = this.convert(vet);
        return this.http.put<VetMySuffix>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<VetMySuffix>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<VetMySuffix[]>> {
        const options = createRequestOption(req);
        return this.http.get<VetMySuffix[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<VetMySuffix[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: VetMySuffix = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<VetMySuffix[]>): HttpResponse<VetMySuffix[]> {
        const jsonResponse: VetMySuffix[] = res.body;
        const body: VetMySuffix[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to VetMySuffix.
     */
    private convertItemFromServer(vet: VetMySuffix): VetMySuffix {
        const copy: VetMySuffix = Object.assign({}, vet);
        return copy;
    }

    /**
     * Convert a VetMySuffix to a JSON which can be sent to the server.
     */
    private convert(vet: VetMySuffix): VetMySuffix {
        const copy: VetMySuffix = Object.assign({}, vet);
        return copy;
    }
}
