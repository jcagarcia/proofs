package org.springframework.roo.petclinic.repository;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = OwnerRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface OwnerRepository extends DetachableJpaRepository<Owner, Long>, OwnerRepositoryCustom {
}
