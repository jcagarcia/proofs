package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.petclinic.domain.Visit;

/**
 * = VisitsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Visit.class, type = ControllerType.COLLECTION)
@RooJSON
public class VisitsCollectionJsonController {
}
