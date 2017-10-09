// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the extended .java class if you wish to edit any member(s).
package io.github.jcagarcia.proofs.springroonoaspectjava.repository;

import io.github.jcagarcia.proofs.springroonoaspectjava.model.Pet;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PetRepositoryCustom_ROO {

    // DO NOT EDIT THIS CODE. THIS CODE IS MANAGED BY THE
    // @RooJpaCustomRepository annotation

    /**
     * TODO Auto-generated method documentation
     *
     * @param search
     * @param pageable
     * @return Page
     */
    Page<Pet> findAll(GlobalSearch search, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param search
     * @param pageable
     * @return Page
     */
    Page<Pet> findAllByIdsIn(List<Long> ids, GlobalSearch search, Pageable pageable);
}
