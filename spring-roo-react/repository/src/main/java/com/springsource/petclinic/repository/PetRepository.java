package com.springsource.petclinic.repository;
import com.springsource.petclinic.model.Pet;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = PetRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Pet.class)
public interface PetRepository extends DetachableJpaRepository<Pet, Long>, PetRepositoryCustom {
}
