package io.github.jcagarcia.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jcagarcia.domain.Vet;
import io.github.jcagarcia.service.VetService;
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
 * REST controller for managing Vet.
 */
@RestController
@RequestMapping("/api")
public class VetResource {

    private final Logger log = LoggerFactory.getLogger(VetResource.class);

    private static final String ENTITY_NAME = "vet";

    private final VetService vetService;

    public VetResource(VetService vetService) {
        this.vetService = vetService;
    }

    /**
     * POST  /vets : Create a new vet.
     *
     * @param vet the vet to create
     * @return the ResponseEntity with status 201 (Created) and with body the new vet, or with status 400 (Bad Request) if the vet has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/vets")
    @Timed
    public ResponseEntity<Vet> createVet(@RequestBody Vet vet) throws URISyntaxException {
        log.debug("REST request to save Vet : {}", vet);
        if (vet.getId() != null) {
            throw new BadRequestAlertException("A new vet cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Vet result = vetService.save(vet);
        return ResponseEntity.created(new URI("/api/vets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /vets : Updates an existing vet.
     *
     * @param vet the vet to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated vet,
     * or with status 400 (Bad Request) if the vet is not valid,
     * or with status 500 (Internal Server Error) if the vet couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/vets")
    @Timed
    public ResponseEntity<Vet> updateVet(@RequestBody Vet vet) throws URISyntaxException {
        log.debug("REST request to update Vet : {}", vet);
        if (vet.getId() == null) {
            return createVet(vet);
        }
        Vet result = vetService.save(vet);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, vet.getId().toString()))
            .body(result);
    }

    /**
     * GET  /vets : get all the vets.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of vets in body
     */
    @GetMapping("/vets")
    @Timed
    public List<Vet> getAllVets() {
        log.debug("REST request to get all Vets");
        return vetService.findAll();
        }

    /**
     * GET  /vets/:id : get the "id" vet.
     *
     * @param id the id of the vet to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the vet, or with status 404 (Not Found)
     */
    @GetMapping("/vets/{id}")
    @Timed
    public ResponseEntity<Vet> getVet(@PathVariable Long id) {
        log.debug("REST request to get Vet : {}", id);
        Vet vet = vetService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(vet));
    }

    /**
     * DELETE  /vets/:id : delete the "id" vet.
     *
     * @param id the id of the vet to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/vets/{id}")
    @Timed
    public ResponseEntity<Void> deleteVet(@PathVariable Long id) {
        log.debug("REST request to delete Vet : {}", id);
        vetService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
