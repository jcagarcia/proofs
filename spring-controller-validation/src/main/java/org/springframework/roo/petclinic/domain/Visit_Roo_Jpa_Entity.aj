// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.springframework.roo.petclinic.domain;

import io.springlets.format.EntityFormat;
import javax.persistence.Entity;
import org.springframework.roo.petclinic.domain.Visit;

privileged aspect Visit_Roo_Jpa_Entity {
    
    declare @type: Visit: @Entity;
    
    declare @type: Visit: @EntityFormat(message = "visit_format");
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String Visit.ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String Visit.ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";
    
}
