package io.github.jcagarcia.springbootgraphql.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity that defines a new Layer of a Travel
 */
@Entity
public class Layer {

    /**
     * Identifier of the layer
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /**
     * The name of the layer
     */
    private String name;

    /**
     * The travel where this layer is configured
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Travel travel;

    /**
     * Default empty constructor
     */
    public Layer() {
        // Nothing to do here
    }

    /**
     * Constructor that receives all the necessar parameters to construct a Layer.
     *
     * @param name
     * @param travel
     */
    public Layer(String name, Travel travel) {
        setName(name);
        setTravel(travel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
