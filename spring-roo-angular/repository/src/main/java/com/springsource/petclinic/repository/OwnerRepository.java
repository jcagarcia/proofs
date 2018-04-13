package com.springsource.petclinic.repository;
import com.springsource.petclinic.model.Owner;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = OwnerRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Owner.class)
public interface OwnerRepository extends DetachableJpaRepository<Owner, Long>, OwnerRepositoryCustom {
}
