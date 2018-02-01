package org.springframework.roo.petclinic.web;

import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

/**
 * = OwnersItemThymeleafController
 * <p>
 * TODO Auto-generated class documentation
 */
@RooController(entity = Owner.class, type = ControllerType.ITEM)
@RooThymeleaf
public class OwnersItemThymeleafController implements ConcurrencyManager<Owner> {

    public static final String EDIT_VIEW_PATH = "owners/edit";
    
    private final ConcurrencyTemplate<Owner> concurrencyTemplate = new ConcurrencyTemplate<>(this);

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
        Owner savedOwner = concurrencyTemplate.execute(owner, model, () -> {
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


	/**
     * TODO Auto-generated constructor documentation
     * 
     * @param ownerService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public OwnersItemThymeleafController(OwnerService ownerService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setOwnerService(ownerService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(OwnersItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(OwnersCollectionThymeleafController.class));
    }
}
