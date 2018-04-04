package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Visit;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.Locale;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.service.api.VisitService;
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

/**
 * = VisitsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Visit.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/visits/{visit}", name = "VisitsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class VisitsItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<VisitsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VisitService visitService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<VisitsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param visitService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public VisitsItemThymeleafController(VisitService visitService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setVisitService(visitService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(VisitsItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(VisitsCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VisitService
     */
    public VisitService getVisitService() {
        return visitService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitService
     */
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
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
    public MethodLinkBuilderFactory<VisitsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<VisitsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<VisitsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<VisitsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Visit
     */
    @ModelAttribute
    public Visit getVisit(@PathVariable("visit") Long id, Locale locale, HttpMethod method) {
        Visit visit = null;
        if (HttpMethod.PUT.equals(method)) {
            visit = visitService.findOneForUpdate(id);
        } else {
            visit = visitService.findOne(id);
        }
        if (visit == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Visit", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return visit;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Visit visit, Model model) {
        model.addAttribute("visit", visit);
        return new ModelAndView("visits/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Visit visit, Model model) {
        model.addAttribute("visit", visit);
        return new ModelAndView("visits/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("visit")
    public void initVisitBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("visitDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Visit visit, Model model) {
        populateForm(model);
        model.addAttribute("visit", visit);
        return new ModelAndView("visits/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Visit visit, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("visits/edit");
        }
        // Concurrency control
        Visit existingVisit = getVisitService().findOne(visit.getId());
        if (visit.getVersion() != existingVisit.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("visit", visit);
            model.addAttribute("concurrency", true);
            return new ModelAndView("visits/edit");
        } else if (visit.getVersion() != existingVisit.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("visit", existingVisit);
            model.addAttribute("concurrency", false);
            return new ModelAndView("visits/edit");
        } else if (visit.getVersion() != existingVisit.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            visit.setVersion(existingVisit.getVersion());
        }
        Visit savedVisit = getVisitService().save(visit);
        UriComponents showURI = getItemLink().to(VisitsItemThymeleafLinkFactory.SHOW).with("visit", savedVisit.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Visit visit) {
        getVisitService().delete(visit);
        return ResponseEntity.ok().build();
    }
}
