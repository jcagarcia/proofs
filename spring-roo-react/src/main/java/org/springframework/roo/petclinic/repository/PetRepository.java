package org.springframework.roo.petclinic.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.petclinic.domain.Pet;

/**
 * = PetRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Pet.class)
public interface PetRepository extends DetachableJpaRepository<Pet, Long>, PetRepositoryCustom {
}
