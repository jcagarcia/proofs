package io.github.jcagarcia.springbootgraphql.repository;

import io.github.jcagarcia.springbootgraphql.model.Layer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link Layer} entity
 */
public interface LayerRepository extends JpaRepository<Layer, Long> {
}
