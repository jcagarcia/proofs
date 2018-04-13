package com.springsource.petclinic.application.web.api;
import com.springsource.petclinic.model.Pet;
import com.springsource.petclinic.model.reference.PetType;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * = PetsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Pet.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class PetsCollectionJsonController {

    /**
     * By default, Sprign Roo generates this method returning a Page. Changing to return just a list
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<List<Pet>> list(GlobalSearch globalSearch, Pageable pageable) {
        List<Pet> pets = getPetService().findAll(globalSearch, pageable).getContent();
        return ResponseEntity.ok(pets);
    }

    /**
     * Obtain all the existing pet types
     *
     * @return
     */
    @GetMapping("/types")
    public List<PetType> getTypes(){
        return Arrays.asList(PetType.values());
    }
}
