package io.github.jcagarcia.springbootgraphql;

import io.github.jcagarcia.springbootgraphql.resolvers.Query;
import io.github.jcagarcia.springbootgraphql.service.api.TravelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlApplication.class, args);
	}

	@Bean
	public Query query(TravelService travelService) {
		return new Query(travelService);
	}
}
