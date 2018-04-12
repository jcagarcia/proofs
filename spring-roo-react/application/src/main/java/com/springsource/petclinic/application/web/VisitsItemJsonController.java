package com.springsource.petclinic.application.web;
import com.springsource.petclinic.model.Visit;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = VisitsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Visit.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
public class VisitsItemJsonController {
}
