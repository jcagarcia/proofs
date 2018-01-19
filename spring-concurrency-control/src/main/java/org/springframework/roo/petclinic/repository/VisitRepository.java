package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;

/**
 * = VisitRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Visit.class, finders = { @RooFinder(value = "findByDescriptionAndVisitDate", returnType = Visit.class), @RooFinder(value = "findByVisitDateBetween", returnType = Visit.class), @RooFinder(value = "findByDescriptionLike", returnType = Visit.class) })
public interface VisitRepository {
}
