package org.springframework.roo.petclinic.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.petclinic.domain.Owner;

/**
 * = OwnerRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Owner.class)
public interface OwnerRepository extends DetachableJpaRepository<Owner, Long>, OwnerRepositoryCustom {
}
