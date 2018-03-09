package io.github.jcagarcia.springbootgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import io.github.jcagarcia.springbootgraphql.model.Travel;
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
     * Default constructor that receives the service
     * @param travelService
     */
    public Query(TravelService travelService) {
        this.travelService = travelService;
    }

    /**
     * Operation that obtains all the registered travels
     * @return
     */
    public List<Travel> findAllTravels() {
        return travelService.findAll();
    }


}
