package org.springframework.roo.petclinic.web;
import java.util.Arrays;
import java.util.Locale;

import javax.validation.Valid;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.domain.reference.Specialty;
import org.springframework.roo.petclinic.service.api.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;

/**
 * = VetsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/vets/{vet}", name = "VetsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class VetsItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<VetsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VetService vetService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param vetService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public VetsItemThymeleafController(VetService vetService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setVetService(vetService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(VetsItemThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VetService
     */
    public VetService getVetService() {
        return vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vetService
     */
    public void setVetService(VetService vetService) {
        this.vetService = vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MessageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param messageSource
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<VetsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<VetsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Vet
     */
    @ModelAttribute
    public Vet getVet(@PathVariable("vet") Long id, Locale locale, HttpMethod method) {
        Vet vet = null;
        if (HttpMethod.PUT.equals(method)) {
            vet = vetService.findOneForUpdate(id);
        } else {
            vet = vetService.findOne(id);
        }
        if (vet == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Vet", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return vet;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Vet vet, Model model) {
        return new ModelAndView("vets/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("vet")
    public void initVetBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("birthDay_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("employedSince_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("createdDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("modifiedDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
        model.addAttribute("specialty", Arrays.asList(Specialty.values()));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Vet vet, Model model) {
        populateForm(model);
        return new ModelAndView("vets/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param version
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Vet vet, @RequestParam("version") Integer version, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("vets/edit");
        }
        Vet savedVet = getVetService().save(vet);
        UriComponents showURI = getItemLink().to(VetsItemThymeleafLinkFactory.SHOW).with("vet", savedVet.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Vet vet) {
        getVetService().delete(vet);
        return ResponseEntity.ok().build();
    }
}
