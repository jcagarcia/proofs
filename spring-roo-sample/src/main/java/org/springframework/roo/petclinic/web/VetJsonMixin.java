package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import org.springframework.roo.petclinic.domain.Vet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import org.springframework.roo.petclinic.domain.Visit;

/**
 * = VetJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Vet.class)
public abstract class VetJsonMixin {

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
}
