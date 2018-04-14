package com.springsource.petclinic.application.web.api;
import com.springsource.petclinic.model.Owner;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * = OwnersCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Owner.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class OwnersCollectionJsonController {

    /**
     * Method that returns a page with all the registered owners
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Owner>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Owner> owners = getOwnerService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(owners);
    }
}
