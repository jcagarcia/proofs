package io.github.jcagarcia.springbootgraphql.service.api;

import io.github.jcagarcia.springbootgraphql.model.City;

import java.util.List;

/**
 * Defines the available operations for a {@link City}
 */
public interface CityService {

    /**
     * Obtains a complete list of cities
     *
     * @return
     */
    List<City> findAll();

    /**
     * Obtains a city from the provided id
     *
     * @param id
     * @return
     */
    City findOne(Long id);


}
