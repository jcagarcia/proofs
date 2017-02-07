package org.springframework.roo.petclinic.web;
import java.util.Set;

import org.springframework.roo.petclinic.domain.Pet;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = OwnerJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
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
