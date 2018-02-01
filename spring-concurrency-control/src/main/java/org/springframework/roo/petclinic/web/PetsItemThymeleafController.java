package org.springframework.roo.petclinic.web;

import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

/**
 * = PetsItemThymeleafController
 * <p>
 * TODO Auto-generated class documentation
 */
@RooController(entity = Pet.class, type = ControllerType.ITEM)
@RooThymeleaf
public class PetsItemThymeleafController implements ConcurrencyManager<Pet> {

    public static final String EDIT_VIEW_PATH = "pets/edit";
    
    private final ConcurrencyTemplate<Pet> concurrencyTemplate = new ConcurrencyTemplate<>(this);

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
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }

        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Pet savedPet = concurrencyTemplate.execute(pet, model, () -> {
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



	/**
     * TODO Auto-generated constructor documentation
     * 
     * @param petService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public PetsItemThymeleafController(PetService petService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setPetService(petService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(PetsItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(PetsCollectionThymeleafController.class));
    }
}
