package org.springframework.roo.petclinic.web;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.domain.VetInfo;
import org.springframework.roo.petclinic.service.api.VetService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.springlets.data.domain.GlobalSearch;

/**
 * = VetsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/vets", name = "VetsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class VetsCollectionJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VetService vetService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param vetService
     */
    @Autowired
    public VetsCollectionJsonController(VetService vetService) {
        this.vetService = vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VetService
     */
    public VetService getVetService() {
        return vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vetService
     */
    public void setVetService(VetService vetService) {
        this.vetService = vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<VetInfo>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<VetInfo> vets = getVetService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(vets);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(VetsCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Vet vet, BindingResult result) {
        if (vet.getId() != null || vet.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Vet newVet = getVetService().save(vet);
        UriComponents showURI = VetsItemJsonController.showURI(newVet);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vets
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Vet> vets, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getVetService().save(vets);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vets
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Vet> vets, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getVetService().save(vets);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getVetService().delete(ids);
        return ResponseEntity.ok().build();
    }
}