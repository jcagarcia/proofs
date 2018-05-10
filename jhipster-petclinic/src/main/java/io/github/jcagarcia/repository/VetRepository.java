package io.github.jcagarcia.repository;

import io.github.jcagarcia.domain.Vet;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Vet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

}
