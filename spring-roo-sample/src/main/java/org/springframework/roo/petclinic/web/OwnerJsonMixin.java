package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import org.springframework.roo.petclinic.domain.Owner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import org.springframework.roo.petclinic.domain.Pet;

/**
 * = OwnerJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Owner.class)
public abstract class OwnerJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Pet> pets;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Pet> getPets() {
        return pets;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pets
     */
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
