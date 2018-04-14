import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { environment } from '../../../environments/environment';

/**
 * Service to manage the Pet service
 */
@Injectable()
export class PetService {

    /**
     * The default constructor
     *
     * @param {HttpClient} http
     */
    constructor(private http: HttpClient) {

    }

    /**
     * Method to obtain all the registered pets
     *
     * @param {string} search
     * @param {number} page
     * @param {number} size
     * @returns {Observable<any>}
     */
    getAll(search:string, page: number, size: number): Observable<any>{
        return this.http.get(environment.api.pets.collection, {
            params: {
                "search[value]": search != undefined && search != null ? search : "",
                "page": page.toString(),
                "size": size.toString(),
            }
        });
    }

    /**
     * Method to obtain an individual pet
     *
     * @param {string} id
     * @returns {Observable<Object>}
     */
    get(id: string): Observable<any> {
        let itemUrl = this.compositeUrl(environment.api.pets.item, id);
        return this.http.get(itemUrl);
    }

    /**
     * Method to add a new pet
     *
     * @param pet
     * @returns {Observable<any>}
     */
    save(pet: any): Observable<any> {
        let result: Observable<Object>;
        if (pet.id != null && pet.version != null) {
            let itemUrl = this.compositeUrl(environment.api.pets.item, pet.id);
            result = this.http.put(itemUrl, pet);
        } else {
            result = this.http.post(environment.api.pets.collection, pet);
        }
        return result;
    }

    /**
     * Method that removes the provided pet id
     *
     * @param {string} href
     * @returns {Observable<Object>}
     */
    remove(id: number): Observable<any> {
        let itemUrl = this.compositeUrl(environment.api.pets.item, id.toString());
        return this.http.delete(itemUrl);
    }

    /**
     * Method that removes
     * @param {Array<any>} selectedPets
     * @returns {Observable<Object>}
     */
    removeAll(selectedPets: Array<any>) {
        let deleteBatchUrl = this.compositeUrl(environment.api.pets.deleteBatch, selectedPets.toString());
        return this.http.delete(deleteBatchUrl);
    }

    /**
     * Obtains all the existing pet types
     *
     * @returns {Observable<Object>}
     */
    getTypes(): Observable<any>{
        return this.http.get(environment.api.pets.types);
    }

    /**
     * Method to construct an item url using the provided url and the
     * provided id
     *
     * @param {string} url
     * @param {string} id
     */
    private compositeUrl(url: string, id: string) {
        if(url.indexOf("_ID_") != -1){
            url = url.replace("_ID_", id);
        }
        return url;
    }

}
