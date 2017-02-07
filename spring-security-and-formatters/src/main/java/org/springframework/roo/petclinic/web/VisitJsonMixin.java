package org.springframework.roo.petclinic.web;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.Vet;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = VisitJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
public abstract class VisitJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = VetDeserializer.class)
    private Vet vet;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = PetDeserializer.class)
    private Pet pet;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Vet
     */
    public Vet getVet() {
        return vet;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     */
    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
