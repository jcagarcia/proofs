package io.github.jcagarcia.springbootgraphql.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Class that represents a Travel
 */
@Entity
public class Travel {

    /**
     * Identifier of a travel
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /**
     * The name of the Travel
     */
    @NotNull
    private String name;

    /**
     * The country destination
     */
    private String country;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
