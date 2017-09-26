package io.github.jcagarcia.proof.tests.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import io.github.jcagarcia.proof.tests.model.domain.Library;

/**
 * = LibraryRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */ 
@RooJpaRepositoryCustomImpl(repository = LibraryRepositoryCustom.class)
public class LibraryRepositoryImpl extends QueryDslRepositorySupportExt<Library> {

    /**
     * TODO Auto-generated constructor documentation
     */
    LibraryRepositoryImpl() {
        super(Library.class);
    }
}