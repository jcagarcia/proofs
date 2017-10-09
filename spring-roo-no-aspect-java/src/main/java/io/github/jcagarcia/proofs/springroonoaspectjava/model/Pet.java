package io.github.jcagarcia.proofs.springroonoaspectjava.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class that defines a Pet entity. It will contain all the necessary Spring Roo
 * annotations to generate code:
 *
 * <b>ITD:</b> Pet_ROO.java
 *
 * @author Juan Carlos García [jcgarcia@disid.com]
 */
//@RooJavaBean
//@RooToString
//@RooEquals
@Entity // Indicates that this class is an entity
public class Pet {

    /**
     * Field that identifies the pet
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    /**
     * Field that contains the Pet version
     */
    @Version
    public Integer version;

    /**
     * Indicates the name of the Pet
     */
    @NotNull
    @Size(min = 1)
    public String name;

    /**
     * Indicates the weight of the pet
     */
    @NotNull
    @Min(0L)
    @NumberFormat
    public Float weight;

}
