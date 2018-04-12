package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.petclinic.domain.Pet;

/**
 * = PetsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Pet.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
public class PetsItemJsonController {
}
