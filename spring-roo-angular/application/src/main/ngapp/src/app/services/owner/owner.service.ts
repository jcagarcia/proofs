import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../../environments/environment';

/**
 * Service to manage the Owner entity
 */
@Injectable()
export class OwnerService {

    /**
     * The default constructor
     *
     * @param {HttpClient} http
     */
    constructor(private http: HttpClient) {

    }

    /**
     * Method to obtain all the registered owners
     *
     * @param {string} search
     * @param {number} page
     * @param {number} size
     * @param {string} sort
     * @returns {Observable<any>}
     */
    getAll(search: string, page: number, size: number, sort:string): Observable<any> {
        return this.http.get(environment.api.owners.collection, {
            params: {
                "search[value]": search != undefined && search != null ? search : "",
                "page": page.toString(),
                "size": size.toString(),
                "sort": sort != undefined ? sort : ""
            }
        });
    }

    /**
     * Method to obtain an individual owner
     *
     * @param {string} id
     * @returns {Observable<Object>}
     */
    get(id: string): Observable<any> {
        let itemUrl = this.compositeUrl(environment.api.owners.item, id);
        return this.http.get(itemUrl);
    }

    /**
     * Method to add a new owner
     *
     * @param owner
     * @returns {Observable<any>}
     */
    save(owner: any): Observable<any> {
        let result: Observable<Object>;
        if (owner.id != null && owner.version != null) {
            let itemUrl = this.compositeUrl(environment.api.owners.item, owner.id);
            result = this.http.put(itemUrl, owner);
        } else {
            result = this.http.post(environment.api.owners.collection, owner);
        }
        return result;
    }

    /**
     * Method that removes the provided owner id
     *
     * @param {string} href
     * @returns {Observable<Object>}
     */
    remove(id: number): Observable<any> {
        let itemUrl = this.compositeUrl(environment.api.owners.item, id.toString());
        return this.http.delete(itemUrl);
    }

    /**
     * Method that removes
     * @param {Array<any>} selectedOwners
     * @returns {Observable<Object>}
     */
    removeAll(selectedOwners: Array<any>) {
        let deleteBatchUrl = this.compositeUrl(environment.api.owners.deleteBatch, selectedOwners.toString());
        return this.http.delete(deleteBatchUrl);
    }

    /**
     * Method to construct an item url using the provided url and the
     * provided id
     *
     * @param {string} url
     * @param {string} id
     */
    private compositeUrl(url: string, id: string) {
        if (url.indexOf("_ID_") != -1) {
            url = url.replace("_ID_", id);
        }
        return url;
    }

}
