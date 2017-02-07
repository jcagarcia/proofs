package org.springframework.roo.petclinic.web;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.PetService;
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
 * = PetsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/pets", name = "PetsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetsCollectionJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetService petService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param petService
     */
    @Autowired
    public PetsCollectionJsonController(PetService petService) {
        this.petService = petService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PetService
     */
    public PetService getPetService() {
        return petService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petService
     */
    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Pet>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Pet> pets = getPetService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(pets);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(PetsCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Pet pet, BindingResult result) {
        if (pet.getId() != null || pet.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Pet newPet = getPetService().save(pet);
        UriComponents showURI = PetsItemJsonController.showURI(newPet);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pets
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Pet> pets, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getPetService().save(pets);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pets
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Pet> pets, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getPetService().save(pets);
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
        getPetService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
