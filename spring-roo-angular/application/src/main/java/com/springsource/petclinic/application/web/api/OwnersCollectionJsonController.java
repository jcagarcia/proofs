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
     * By default, Sprign Roo generates this method returning a Page. Changing to return just a list
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<List<Owner>> list(GlobalSearch globalSearch, Pageable pageable) {
        List<Owner> owners = getOwnerService().findAll(globalSearch, pageable).getContent();
        return ResponseEntity.ok(owners);
    }
}
