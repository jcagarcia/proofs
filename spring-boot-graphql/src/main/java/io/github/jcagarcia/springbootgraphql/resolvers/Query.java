package io.github.jcagarcia.springbootgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import io.github.jcagarcia.springbootgraphql.model.Layer;
import io.github.jcagarcia.springbootgraphql.model.Travel;
import io.github.jcagarcia.springbootgraphql.service.api.LayerService;
import io.github.jcagarcia.springbootgraphql.service.api.TravelService;

import java.util.List;

/**
 * Register a GraphQLQueryResolver
 */
public class Query implements GraphQLQueryResolver {

    /**
     * The service to obtain all the travels
     */
    private TravelService travelService;

    /**
     * The service to obtain all the layers
     */
    private LayerService layerService;

    /**
     * Default constructor that receives the service
     *
     * @param travelService
     * @param layerService
     */
    public Query(TravelService travelService, LayerService layerService) {
        this.travelService = travelService;
        this.layerService = layerService;
    }

    /**
     * Operation that obtains all the registered travels
     *
     * @return
     */
    public List<Travel> findAllTravels() {
        return travelService.findAll();
    }

    /**
     * Operation that obtains all the registered layers
     *
     * @return
     */
    public List<Layer> findAllLayers() {
        return layerService.findAll();
    }


}
