package com.springsource.petclinic.application.web;
import com.springsource.petclinic.model.Visit;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = VisitsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Visit.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class VisitsCollectionJsonController {
}
