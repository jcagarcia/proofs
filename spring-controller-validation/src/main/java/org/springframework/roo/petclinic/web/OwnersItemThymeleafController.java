package org.springframework.roo.petclinic.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.web.validators.GenericValidator;
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
 * = OwnersItemThymeleafController
 * <p>
 * TODO Auto-generated class documentation
 */
@RooController(entity = Owner.class, type = ControllerType.ITEM)
@RooThymeleaf
public class OwnersItemThymeleafController implements ConcurrencyManager<Owner> {

    public static final String EDIT_VIEW_PATH = "owners/edit";


    /**
     * Registering Binding validators to be able to use them during the Binding
     * process.
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        // Creates a new Generic Validator provinding a valid service
        GenericValidator genericValidator = new GenericValidator(getOwnerService());
        // Register all the necessary validators
        binder.addValidators(genericValidator);
    }

    /**
     * Method that updates the provided reocord managing concurrency
     *
     * @param owner
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Owner owner, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);

            return new ModelAndView(getEditViewPath());
        }

        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Owner savedOwner = new ConcurrencyTemplate<Owner>(this, owner, model).execute(() -> {
            return getOwnerService().save(owner);
        });

        UriComponents showURI = getItemLink().to(OwnersItemThymeleafLinkFactory.SHOW).with("owner", savedOwner.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getModelName() {
        return "owner";
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
    public Integer getLastVersion(Owner record) {
        return getOwnerService().findOne(record.getId()).getVersion();
    }

}
