package org.springframework.roo.petclinic.web;
import java.util.Set;

import org.springframework.roo.petclinic.domain.Visit;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * = VetJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
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
