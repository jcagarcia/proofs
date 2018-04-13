package com.springsource.petclinic.application.web.api;
import com.springsource.petclinic.model.Pet;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

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
