package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import org.springframework.roo.petclinic.domain.OwnerFirstNameFormBean;
import org.springframework.roo.petclinic.domain.OwnerCityFormBean;
import org.springframework.roo.petclinic.domain.OwnerInfo;

/**
 * = OwnerRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Owner.class, finders = { @RooFinder(value = "findByFirstNameLike", returnType = Owner.class, formBean = OwnerFirstNameFormBean.class), @RooFinder(value = "findByCityLike", returnType = OwnerInfo.class, formBean = OwnerCityFormBean.class) })
public interface OwnerRepository {
}
