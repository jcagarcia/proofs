package io.github.jcagarcia.springbootgraphql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a Travel
 */
@Entity
public class Travel {

    /**
     * Identifier of a travel
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    /**
     * All the layers in this Travel
     */
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "travel")
    private Set<Layer> layers = new HashSet<Layer>();

    /**
     * Default empty constructor
     */
    public Travel() {
        // Nothing to do here
    }

    /**
     * Constructor that receives all the necessary parameters
     *
     * @param name
     * @param country
     */
    public Travel(String name, String country) {
        setName(name);
        setCountry(country);
    }

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

    public Set<Layer> getLayers() {
        return layers;
    }

    public void setLayers(Set<Layer> layers) {
        this.layers = layers;
    }


}
