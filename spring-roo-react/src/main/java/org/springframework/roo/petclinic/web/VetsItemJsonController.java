package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.petclinic.domain.Vet;

/**
 * = VetsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Vet.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
public class VetsItemJsonController {
}
