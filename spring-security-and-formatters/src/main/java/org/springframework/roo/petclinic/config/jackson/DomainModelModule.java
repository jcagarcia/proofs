package org.springframework.roo.petclinic.config.jackson;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.petclinic.web.OwnerJsonMixin;
import org.springframework.roo.petclinic.web.PetJsonMixin;
import org.springframework.roo.petclinic.web.VetJsonMixin;
import org.springframework.roo.petclinic.web.VisitJsonMixin;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
@JsonComponent
public class DomainModelModule extends SimpleModule {

    /**
     * TODO Auto-generated constructor documentation
     *
     */
    public DomainModelModule() {
        // Mixin registration
        setMixInAnnotation(Owner.class, OwnerJsonMixin.class);
        setMixInAnnotation(Pet.class, PetJsonMixin.class);
        setMixInAnnotation(Vet.class, VetJsonMixin.class);
        setMixInAnnotation(Visit.class, VisitJsonMixin.class);
    }
}
