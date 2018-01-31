package org.springframework.roo.petclinic.web;

import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.web.validators.GenericValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * = PetsCollectionThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Pet.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class PetsCollectionThymeleafController {

    /**
     * Registering Binding validators to be able to use them during the Binding
     * process.
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        // Creates a new GenericValidator provinding a valid service
        GenericValidator genericValidator = new GenericValidator(getPetService());
        // Register all the necessary validators
        binder.addValidators(genericValidator);
    }
}
