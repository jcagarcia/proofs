// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.springsource.petclinic.application.web.utils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.springsource.petclinic.application.web.utils.VetDeserializer;
import com.springsource.petclinic.application.web.utils.VisitJsonMixin;
import com.springsource.petclinic.model.Vet;

privileged aspect VisitJsonMixin_Roo_JSONMixin {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    @JsonDeserialize(using = VetDeserializer.class)
    private Vet VisitJsonMixin.vet;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Vet
     */
    public Vet VisitJsonMixin.getVet() {
        return vet;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param vet
     */
    public void VisitJsonMixin.setVet(Vet vet) {
        this.vet = vet;
    }
    
}
