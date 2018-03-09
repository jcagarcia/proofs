package io.github.jcagarcia.springbootgraphql.service.api;

import io.github.jcagarcia.springbootgraphql.model.Travel;

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
}
