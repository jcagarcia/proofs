package org.springframework.roo.petclinic.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.domain.Visit;

import io.springlets.data.domain.GlobalSearch;

/**
 * = VisitRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
public interface VisitRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByVet(Vet vet, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findByPet(Pet pet, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Visit> findAll(GlobalSearch globalSearch, Pageable pageable);
}
