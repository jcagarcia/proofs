import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class PetService {

    public PETS_URL = '/api/pets';

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
     * @returns {Observable<any>}
     */
    getAll(): Observable<any> {
        return this.http.get(this.PETS_URL);
    }

    /**
     * Method to obtain an individual pet
     *
     * @param {string} id
     * @returns {Observable<Object>}
     */
    get(id: string) {
        return this.http.get(this.PETS_URL + '/' + id);
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
            result = this.http.put(this.PETS_URL + '/' + pet.id, pet);
        } else {
            result = this.http.post(this.PETS_URL, pet);
        }
        return result;
    }

    /**
     * Method that removes the provided pet id
     *
     * @param {string} href
     * @returns {Observable<Object>}
     */
    remove(id: string) {
        return this.http.delete(this.PETS_URL + '/' + id);
    }

    /**
     * Obtains all the existing pet types
     *
     * @returns {Observable<Object>}
     */
    getTypes(){
        return this.http.get(this.PETS_URL + '/types');
    }


}
