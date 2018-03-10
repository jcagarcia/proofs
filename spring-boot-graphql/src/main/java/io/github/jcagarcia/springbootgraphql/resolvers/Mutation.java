package io.github.jcagarcia.springbootgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import io.github.jcagarcia.springbootgraphql.model.Layer;
import io.github.jcagarcia.springbootgraphql.model.Travel;
import io.github.jcagarcia.springbootgraphql.service.api.LayerService;
import io.github.jcagarcia.springbootgraphql.service.api.TravelService;

/**
 * Register a GraphQLMutationResolver
 */
public class Mutation implements GraphQLMutationResolver {

    /**
     * The service to manage all the travels
     */
    private TravelService travelService;

    /**
     * The service to manage all the layers
     */
    private LayerService layerService;

    /**
     * Default constructor
     *
     * @param travelService
     * @param layerService
     */
    public Mutation(TravelService travelService, LayerService layerService) {
        this.travelService = travelService;
        this.layerService = layerService;
    }

    /**
     * Method that creates a new Travel
     *
     * @param name
     * @param country
     * @return
     */
    public Travel createTravel(String name, String country){
        return travelService.create(name, country);
    }

    /**
     * Creates a new Layer
     *
     * @param travel
     * @param name
     * @return
     */
    public Layer createLayer(Long travel, String name){
        return layerService.create(travel, name);
    }
}
