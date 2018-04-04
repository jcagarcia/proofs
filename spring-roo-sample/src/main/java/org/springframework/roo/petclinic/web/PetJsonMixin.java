package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import org.springframework.roo.petclinic.domain.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.Visit;

/**
 * = PetJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Pet.class)
public abstract class PetJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = OwnerDeserializer.class)
    private Owner owner;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Visit> visits;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Visit> getVisits() {
        return visits;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visits
     */
    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
