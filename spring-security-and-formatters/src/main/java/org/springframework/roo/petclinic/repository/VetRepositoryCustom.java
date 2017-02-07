package org.springframework.roo.petclinic.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.VetInfo;

import io.springlets.data.domain.GlobalSearch;

/**
 * = VetRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
public interface VetRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<VetInfo> findAll(GlobalSearch globalSearch, Pageable pageable);
}
