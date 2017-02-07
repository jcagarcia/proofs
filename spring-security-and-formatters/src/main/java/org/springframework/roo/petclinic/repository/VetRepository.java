package org.springframework.roo.petclinic.repository;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = VetRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface VetRepository extends DetachableJpaRepository<Vet, Long>, VetRepositoryCustom {
}
