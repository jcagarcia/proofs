package org.springframework.roo.petclinic.web;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;

/**
 * = PetsItemThymeleafController
 * <p>
 * TODO Auto-generated class documentation
 */
@RooController(entity = Pet.class, type = ControllerType.ITEM)
@RooThymeleaf
public class PetsItemThymeleafController {

    /**
     * Update method that should manage concurrency
     *
     * @param pet
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Pet pet, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("pets/edit");
        }
        Pet savedPet = null;
        try {
            savedPet = getPetService().save(pet);
        } catch (ObjectOptimisticLockingFailureException ex) { // Managing concurrency
            // Populate the form with all the concurrency information
            populateConcurrencyForm(model, pet);
            // Return the edit view
            return new ModelAndView("pets/edit");
        }
        UriComponents showURI = getItemLink().to(PetsItemThymeleafLinkFactory.SHOW).with("pet", savedPet.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * Method to populate form with all the necessary elements to display the
     * concurrency management.
     *
     * @param model
     * @param entity
     */
    private void populateConcurrencyForm(Model model, Pet entity) {
        // First of all, populate the form with all the necessary things
        populateForm(model);

        // Add concurrency attribute to the model to show the concurrency form
        // in the current edit view
        model.addAttribute("concurrency", true);
        // Add the new version value to the model.
        Pet existingPet = getPetService().findOne(entity.getId());
        model.addAttribute("newVersion", existingPet.getVersion());
        // Add the current pet values to maintain the values introduced by the user
        model.addAttribute("pet", entity);
    }


}
