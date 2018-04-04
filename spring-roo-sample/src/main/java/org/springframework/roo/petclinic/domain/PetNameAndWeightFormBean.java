package org.springframework.roo.petclinic.domain;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.format.annotation.NumberFormat;
import io.springlets.format.EntityFormat;

/**
 * = PetNameAndWeightFormBean
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
@EntityFormat
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Float
     */
    public Float getWeight() {
        return this.weight;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param weight
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
