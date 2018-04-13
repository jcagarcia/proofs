package com.springsource.petclinic.application.web.utils;
import com.springsource.petclinic.model.Pet;
import com.springsource.petclinic.service.api.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = PetDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Pet.class)
public class PetDeserializer extends JsonObjectDeserializer<Pet> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetService petService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param petService
     * @param conversionService
     */
    @Autowired
    public PetDeserializer(@Lazy PetService petService, ConversionService conversionService) {
        this.petService = petService;
        this.conversionService = conversionService;
    }
}
