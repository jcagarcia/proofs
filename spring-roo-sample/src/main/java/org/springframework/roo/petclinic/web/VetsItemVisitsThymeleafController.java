package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Vet;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.petclinic.service.api.VetService;
import org.springframework.roo.petclinic.service.api.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * = VetsItemVisitsThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Vet.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "visits", views = { "list", "show" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/vets/{vet}/visits", name = "VetsItemVisitsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class VetsItemVisitsThymeleafController {

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
    private ConversionService conversionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<VetsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VetService vetService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param vetService
     * @param visitService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public VetsItemVisitsThymeleafController(VetService vetService, VisitService visitService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setVetService(vetService);
        setVisitService(visitService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(VetsCollectionThymeleafController.class));
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
    public MethodLinkBuilderFactory<VetsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<VetsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
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
     * @param vet
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Visit>> datatables(@ModelAttribute Vet vet, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Visit> visits = getVisitService().findByVet(vet, search, pageable);
        long totalVisitsCount = getVisitService().countByVet(vet);
        ConvertedDatatablesData<Visit> data = new ConvertedDatatablesData<Visit>(visits, totalVisitsCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatablesByIdsIn", produces = Datatables.MEDIA_TYPE, value = "/dtByIdsIn")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Visit>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Visit> visits = getVisitService().findAllByIdsIn(ids, search, pageable);
        long totalVisitsCount = visits.getTotalElements();
        ConvertedDatatablesData<Visit> data = new ConvertedDatatablesData<Visit>(visits, totalVisitsCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Vet vet, Model model) {
        populateForm(model);
        model.addAttribute("visit", new Visit());
        return new ModelAndView("vets/visits/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visitsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromVisits", value = "/{visitsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromVisits(@ModelAttribute Vet vet, @PathVariable("visitsToRemove") Long visitsToRemove) {
        getVetService().removeFromVisits(vet, Collections.singleton(visitsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visitsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromVisitsBatch", value = "/batch/{visitsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromVisitsBatch(@ModelAttribute Vet vet, @PathVariable("visitsToRemove") Collection<Long> visitsToRemove) {
        getVetService().removeFromVisits(vet, visitsToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @param visits
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Vet vet, @RequestParam(value = "visitsIds", required = false) List<Long> visits, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (visits != null) {
            for (Iterator<Long> iterator = visits.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (version != vet.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (visits != null) {
                vet.setVisits(new HashSet<Visit>(getVisitService().findAll(visits)));
            } else {
                vet.setVisits(new HashSet<Visit>());
            }
            // Reset the version to prevent update
            vet.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("vet", vet);
            model.addAttribute("concurrency", true);
            return new ModelAndView("vets/visits/create");
        } else if (version != vet.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("vet", vet);
            model.addAttribute("concurrency", false);
            return new ModelAndView("vets/visits/create");
        }
        getVetService().setVisits(vet, visits);
        return new ModelAndView("redirect:" + getCollectionLink().to(VetsCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
