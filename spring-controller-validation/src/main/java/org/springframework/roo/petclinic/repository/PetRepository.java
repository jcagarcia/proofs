package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import org.springframework.roo.petclinic.domain.PetNameAndWeightFormBean;

import java.util.List;

/**
 * = PetRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Pet.class, finders = { @RooFinder(value = "findByNameAndWeight", returnType = Pet.class, formBean = PetNameAndWeightFormBean.class), @RooFinder(value = "findByOwner", returnType = Pet.class), @RooFinder(value = "findBySendRemindersAndWeightLessThan", returnType = Pet.class), @RooFinder(value = "findByTypeAndNameLike", returnType = Pet.class) })
public interface PetRepository {

    /**
     * Named Query method that allows developers to find pets by the provided name
     *
     * @param name
     * @return
     */
    List<Pet> findByName(String name);
}
