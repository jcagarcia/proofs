package io.github.jcagarcia.proofs.springroonoaspectjava.repository;

import io.github.jcagarcia.proofs.springroonoaspectjava.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface that defines a repository for the Pet entity. Developer could
 * create the necessary named queries here. If some query needs a QueryDSL implementation,
 * use the PetRepositoryCustom interface to define it.
 *
 * * <b>ITD:</b> No ITDs are related to this interface.
 *
 * @author Juan Carlos García [jcgarcia@disid.com]
 */
// @RooJpaRepository(entity = Pet.class) --> Spring Roo annotation that doesn't generate code.
//                                           Just used to identify the repository of an entity
@Transactional(readOnly = true)
public interface PetRepository extends JpaRepository<Pet, Long>, PetRepositoryCustom {
}
