package io.github.jcagarcia.springbootgraphql.service.api;

import io.github.jcagarcia.springbootgraphql.model.Layer;

import java.util.List;

/**
 * Service to manage Layer entity
 */
public interface LayerService {

    /**
     * Obtains all the registered layers
     *
     * @return
     */
    List<Layer> findAll();

    /**
     * Creates a new layer using the provided travel code and the provided name
     *
     * @param travelId
     * @param name
     * @return
     */
    Layer create(Long travelId, String name);
}
