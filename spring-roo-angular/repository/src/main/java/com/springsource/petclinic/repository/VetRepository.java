package com.springsource.petclinic.repository;
import com.springsource.petclinic.model.Vet;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = VetRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Vet.class)
public interface VetRepository extends DetachableJpaRepository<Vet, Long>, VetRepositoryCustom {
}
