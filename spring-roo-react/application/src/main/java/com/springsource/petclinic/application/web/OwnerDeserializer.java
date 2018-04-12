package com.springsource.petclinic.application.web;
import com.springsource.petclinic.model.Owner;
import com.springsource.petclinic.service.api.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = OwnerDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Owner.class)
public class OwnerDeserializer extends JsonObjectDeserializer<Owner> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OwnerService ownerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param ownerService
     * @param conversionService
     */
    @Autowired
    public OwnerDeserializer(@Lazy OwnerService ownerService, ConversionService conversionService) {
        this.ownerService = ownerService;
        this.conversionService = conversionService;
    }
}
