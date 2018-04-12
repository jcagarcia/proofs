package org.springframework.roo.petclinic.domain;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * = AbstractPerson
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooEquals(isJpaEntity = true)
public abstract class AbstractPerson {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    private Integer version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Size(min = 3, max = 30)
    private String firstName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(min = 1, max = 50)
    private String address;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Size(max = 30)
    private String city;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    private String telephone;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Size(max = 30)
    private String homePage;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Size(min = 6, max = 30)
    private String email;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date birthDay;
}
