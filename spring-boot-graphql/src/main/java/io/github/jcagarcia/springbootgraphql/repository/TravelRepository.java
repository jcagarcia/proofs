package io.github.jcagarcia.springbootgraphql.repository;

import io.github.jcagarcia.springbootgraphql.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage {@link Travel} entity
 */
public interface TravelRepository extends JpaRepository<Travel, Long> {

    /**
     * Method that obtains a travel using the provided url code
     *
     * @param urlCode
     * @return
     */
    Travel findAllByUrlCode(String urlCode);
}
