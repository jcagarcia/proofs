package org.springframework.roo.petclinic.domain;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.format.annotation.NumberFormat;

/**
 * = PetNameAndWeightFormBean
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
public class PetNameAndWeightFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Float weight;
}
