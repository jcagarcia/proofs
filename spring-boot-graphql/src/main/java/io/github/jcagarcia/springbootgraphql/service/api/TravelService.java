package io.github.jcagarcia.springbootgraphql.service.api;

import io.github.jcagarcia.springbootgraphql.model.Travel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Defines the available operations for a {@link Travel}
 */
public interface TravelService {

    /**
     * Obtains a complete list of travels registered in the system
     *
     * @return
     */
    List<Travel> findAll();

    /**
     * Obtains a travel from the provided urlCOde
     *
     * @param urlCode
     * @return
     */
    Travel findByUrlCode(String urlCode);

    /**
     * Method to save the travel
     *
     * @param travel
     * @return
     */
    Travel save(Travel travel);

    /**
     * Method to create a new Travel
     *
     * @param startDate
     * @param endDate
     * @param country
     * @return
     */
    Travel create(Date startDate, Date endDate, String country);


}
