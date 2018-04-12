package com.springsource.petclinic.repository;
import com.springsource.petclinic.model.Visit;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = VisitRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Visit.class)
public interface VisitRepository extends DetachableJpaRepository<Visit, Long>, VisitRepositoryCustom {
}
