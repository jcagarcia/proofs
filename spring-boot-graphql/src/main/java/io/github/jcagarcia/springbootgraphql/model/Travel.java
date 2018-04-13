package io.github.jcagarcia.springbootgraphql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
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
     * The day that the travel starts
     */
    private Date startDate;

    /**
     * The day when the travel ends
     */
    private Date endDate;

    /**
     * The country destination
     */
    private String country;

    /**
     * Code that identifies the URL
     */
    private String urlCode;

    /**
     * All the cities provided for this travel
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<City>();

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
     * @param startDate
     * @param endDate
     * @param country
     */
    public Travel(Date startDate, Date endDate, String country) {
        setStartDate(startDate);
        setEndDate(endDate);
        setCountry(country);
        generateCode();
    }

    /**
     * Utility method that generates code using the current setted values
     */
    private void generateCode() {
        String properties = getStartDate().getTime() + getEndDate().getTime() + getCountry();
        setUrlCode("we" + properties.hashCode() + "trip");
    }

    /**
     * Method that obtains the duration of the travel
     * @return
     */
    public Integer getDuration(){
        // TODO
        return null;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public void setUrlCode(String urlCode) {
        this.urlCode = urlCode;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    /**
     * Method that includes a new city in this Travel
     *
     * @param city
     */
    public void addCity(City city) {
        if(!getCities().contains(city)){
            getCities().add(city);
        }
    }
}
