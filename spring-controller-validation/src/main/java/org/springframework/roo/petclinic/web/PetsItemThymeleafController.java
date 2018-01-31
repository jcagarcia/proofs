package org.springframework.roo.petclinic.web;

import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.web.validators.PetValidator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class PetsItemThymeleafController implements ConcurrencyManager<Pet> {

    public static final String EDIT_VIEW_PATH = "pets/edit";

    /**
     * Registering Binding validators to be able to use them during the Binding
     * process.
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        // Creates a new PetValidator provinding a valid service
        PetValidator petValidator = new PetValidator(getPetService());
        // Register all the necessary validators
        binder.addValidators(petValidator);
    }

    /**
     * Update method that should manage concurrency
     *
     * @param pet
     * @param result
     * @param version
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Pet pet, BindingResult result, @RequestParam("version") Integer version, Model model) {
        // Check if provided form contain errors
        // Because we've registered a PetValidator, the provided pet should be valid.
        // If not, all the errors will be displayed in the edit view.
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }

        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Pet savedPet = new ConcurrencyTemplate<Pet>(this, pet, model).execute(() -> {
            return getPetService().save(pet);
        });

        UriComponents showURI = getItemLink().to(PetsItemThymeleafLinkFactory.SHOW).with("pet", savedPet.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getModelName() {
        return "pet";
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getEditViewPath() {
        return EDIT_VIEW_PATH;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Integer getLastVersion(Pet record) {
        return getPetService().findOne(record.getId()).getVersion();
    }


}
