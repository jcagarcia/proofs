// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.springsource.petclinic.application.web.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.springsource.petclinic.application.web.utils.VisitDeserializer;
import com.springsource.petclinic.model.Visit;
import com.springsource.petclinic.service.api.VisitService;
import io.springlets.web.NotFoundException;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.core.convert.ConversionService;

privileged aspect VisitDeserializer_Roo_EntityDeserializer {
    
    declare @type: VisitDeserializer: @JsonComponent;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return VisitService
     */
    public VisitService VisitDeserializer.getVisitService() {
        return visitService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param visitService
     */
    public void VisitDeserializer.setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return ConversionService
     */
    public ConversionService VisitDeserializer.getConversionService() {
        return conversionService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param conversionService
     */
    public void VisitDeserializer.setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Visit
     * @throws IOException
     */
    public Visit VisitDeserializer.deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Visit visit = visitService.findOne(id);
        if (visit == null) {
            throw new NotFoundException("Visit not found");
        }
        return visit;
    }
    
}
