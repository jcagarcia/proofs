package io.github.jcagarcia.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jcagarcia.domain.Pet;
import io.github.jcagarcia.service.PetService;
import io.github.jcagarcia.web.rest.errors.BadRequestAlertException;
import io.github.jcagarcia.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Pet.
 */
@RestController
@RequestMapping("/api")
public class PetResource {

    private final Logger log = LoggerFactory.getLogger(PetResource.class);

    private static final String ENTITY_NAME = "pet";

    private final PetService petService;

    public PetResource(PetService petService) {
        this.petService = petService;
    }

    /**
     * POST  /pets : Create a new pet.
     *
     * @param pet the pet to create
     * @return the ResponseEntity with status 201 (Created) and with body the new pet, or with status 400 (Bad Request) if the pet has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/pets")
    @Timed
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) throws URISyntaxException {
        log.debug("REST request to save Pet : {}", pet);
        if (pet.getId() != null) {
            throw new BadRequestAlertException("A new pet cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Pet result = petService.save(pet);
        return ResponseEntity.created(new URI("/api/pets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /pets : Updates an existing pet.
     *
     * @param pet the pet to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated pet,
     * or with status 400 (Bad Request) if the pet is not valid,
     * or with status 500 (Internal Server Error) if the pet couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/pets")
    @Timed
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) throws URISyntaxException {
        log.debug("REST request to update Pet : {}", pet);
        if (pet.getId() == null) {
            return createPet(pet);
        }
        Pet result = petService.save(pet);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, pet.getId().toString()))
            .body(result);
    }

    /**
     * GET  /pets : get all the pets.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of pets in body
     */
    @GetMapping("/pets")
    @Timed
    public List<Pet> getAllPets() {
        log.debug("REST request to get all Pets");
        return petService.findAll();
        }

    /**
     * GET  /pets/:id : get the "id" pet.
     *
     * @param id the id of the pet to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the pet, or with status 404 (Not Found)
     */
    @GetMapping("/pets/{id}")
    @Timed
    public ResponseEntity<Pet> getPet(@PathVariable Long id) {
        log.debug("REST request to get Pet : {}", id);
        Pet pet = petService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(pet));
    }

    /**
     * DELETE  /pets/:id : delete the "id" pet.
     *
     * @param id the id of the pet to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/pets/{id}")
    @Timed
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        log.debug("REST request to delete Pet : {}", id);
        petService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
