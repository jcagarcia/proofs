package org.springframework.roo.petclinic.repository;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.petclinic.domain.Visit;

/**
 * = VisitRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Visit.class)
public interface VisitRepository extends DetachableJpaRepository<Visit, Long>, VisitRepositoryCustom {
}
