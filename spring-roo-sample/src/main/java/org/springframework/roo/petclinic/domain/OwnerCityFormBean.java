package org.springframework.roo.petclinic.domain;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import io.springlets.format.EntityFormat;

/**
 * = OwnerCityFormBean
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
@EntityFormat
public class OwnerCityFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String city;

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCity() {
        return this.city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
}
