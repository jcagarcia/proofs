package com.springsource.petclinic.application.web.api;
import com.springsource.petclinic.model.Vet;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

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
