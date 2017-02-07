package org.springframework.roo.petclinic.web;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;

/**
 * = PetsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/pets/{pet}", name = "PetsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetsItemJsonController {

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
    public PetsItemJsonController(PetService petService) {
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
     * @param id
     * @return Pet
     */
    @ModelAttribute
    public Pet getPet(@PathVariable("pet") Long id) {
        Pet pet = petService.findOne(id);
        if (pet == null) {
            throw new NotFoundException(String.format("Pet with identifier '%s' not found", id));
        }
        return pet;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Pet pet) {
        return ResponseEntity.ok(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @return UriComponents
     */
    public static UriComponents showURI(Pet pet) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(PetsItemJsonController.class).show(pet)).buildAndExpand(pet.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedPet
     * @param pet
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Pet storedPet, @Valid @RequestBody Pet pet, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        pet.setId(storedPet.getId());
        getPetService().save(pet);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Pet pet) {
        getPetService().delete(pet);
        return ResponseEntity.ok().build();
    }
}
