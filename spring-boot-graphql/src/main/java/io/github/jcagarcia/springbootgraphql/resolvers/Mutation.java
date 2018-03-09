package io.github.jcagarcia.springbootgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import io.github.jcagarcia.springbootgraphql.model.Travel;
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
     * Default constructor
     *
     * @param travelService
     */
    public Mutation(TravelService travelService) {
        this.travelService = travelService;
    }

    /**
     * Method that creates a new Travel
     *
     * @param name
     * @param country
     * @return
     */
    public Travel create(String name, String country){
        return travelService.create(name, country);
    }
}
