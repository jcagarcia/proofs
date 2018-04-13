package io.github.jcagarcia.springbootgraphql.repository;

import io.github.jcagarcia.springbootgraphql.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link City} entity
 */
public interface CityRepository extends JpaRepository<City, Long> {
}
