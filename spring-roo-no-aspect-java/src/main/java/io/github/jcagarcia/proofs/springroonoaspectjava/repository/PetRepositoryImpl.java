package io.github.jcagarcia.proofs.springroonoaspectjava.repository;

import io.github.jcagarcia.proofs.springroonoaspectjava.model.Pet;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class that defines the implementation of a custom repository for the Pet entity.
 * Developer should implement here the queries defined inside the PetCustomRepository.java
 * interface.
 *
 * * <b>ITD:</b> PetRepositoryImpl_ROO.java
 *
 * @author Juan Carlos García [jcgarcia@disid.com]
 */
// @RooJpaRepositoryCustomImpl(repository = PetRepositoryCustom.class)
public class PetRepositoryImpl extends PetRepositoryImpl_ROO {
}
