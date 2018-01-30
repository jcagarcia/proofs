package org.springframework.roo.petclinic.domain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.dto.annotations.RooEntityProjection;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;

/**
 * = OwnerInfo
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean(settersByDefault = false)
@RooToString
@RooEquals
@RooEntityProjection(entity = Owner.class, fields = { "id", "firstName", "lastName", "city" })
public class OwnerInfo {

    private Long id;

    @Size(min = 3, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    @NotNull
    @Size(max = 30)
    private String city;
}
