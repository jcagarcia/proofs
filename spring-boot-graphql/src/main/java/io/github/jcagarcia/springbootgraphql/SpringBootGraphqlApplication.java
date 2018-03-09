package io.github.jcagarcia.springbootgraphql;

import io.github.jcagarcia.springbootgraphql.resolvers.Mutation;
import io.github.jcagarcia.springbootgraphql.resolvers.Query;
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
     * @return
     */
    @Bean
    public Query query(TravelService travelService) {
        return new Query(travelService);
    }

    /**
     * Register the Mutation component in the Spring Context
     *
     * @param travelService
     * @return
     */
    @Bean
    public Mutation mutation(TravelService travelService) {
        return new Mutation(travelService);
    }
}
