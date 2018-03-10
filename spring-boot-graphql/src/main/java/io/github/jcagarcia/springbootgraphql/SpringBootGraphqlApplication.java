package io.github.jcagarcia.springbootgraphql;

import io.github.jcagarcia.springbootgraphql.resolvers.Mutation;
import io.github.jcagarcia.springbootgraphql.resolvers.Query;
import io.github.jcagarcia.springbootgraphql.service.api.LayerService;
import io.github.jcagarcia.springbootgraphql.service.api.TravelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot main class that configures the application
 */
@SpringBootApplication
public class SpringBootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGraphqlApplication.class, args);
    }

    /**
     * Register the Query component in the Spring Context
     *
     * @param travelService
     * @param layerService
     * @return
     */
    @Bean
    public Query query(TravelService travelService, LayerService layerService) {
        return new Query(travelService, layerService);
    }

    /**
     * Register the Mutation component in the Spring Context
     *
     * @param travelService
     * @param layerService
     * @return
     */
    @Bean
    public Mutation mutation(TravelService travelService, LayerService layerService) {
        return new Mutation(travelService, layerService);
    }
}
