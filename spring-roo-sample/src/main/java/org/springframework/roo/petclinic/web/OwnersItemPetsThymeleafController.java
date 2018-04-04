package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Owner;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.Arrays;
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
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.reference.PetType;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.roo.petclinic.service.api.PetService;
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
 * = OwnersItemPetsThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Owner.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "pets", views = { "list", "show", "findByCityLike" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/owners/{owner}/pets", name = "OwnersItemPetsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class OwnersItemPetsThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetService petService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OwnerService ownerService;

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
    private MethodLinkBuilderFactory<OwnersCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param ownerService
     * @param petService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public OwnersItemPetsThymeleafController(OwnerService ownerService, PetService petService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setOwnerService(ownerService);
        setPetService(petService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(OwnersCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OwnerService
     */
    public OwnerService getOwnerService() {
        return ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ownerService
     */
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PetService
     */
    public PetService getPetService() {
        return petService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petService
     */
    public void setPetService(PetService petService) {
        this.petService = petService;
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
    public MethodLinkBuilderFactory<OwnersCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<OwnersCollectionThymeleafController> collectionLink) {
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
     * @return Owner
     */
    @ModelAttribute
    public Owner getOwner(@PathVariable("owner") Long id, Locale locale, HttpMethod method) {
        Owner owner = null;
        if (HttpMethod.PUT.equals(method)) {
            owner = ownerService.findOneForUpdate(id);
        } else {
            owner = ownerService.findOne(id);
        }
        if (owner == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Owner", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return owner;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
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
        model.addAttribute("type", Arrays.asList(PetType.values()));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Pet>> datatables(@ModelAttribute Owner owner, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Pet> pets = getPetService().findByOwner(owner, search, pageable);
        long totalPetsCount = getPetService().countByOwner(owner);
        ConvertedDatatablesData<Pet> data = new ConvertedDatatablesData<Pet>(pets, totalPetsCount, draw, getConversionService(), datatablesColumns);
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
    public ResponseEntity<ConvertedDatatablesData<Pet>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Pet> pets = getPetService().findAllByIdsIn(ids, search, pageable);
        long totalPetsCount = pets.getTotalElements();
        ConvertedDatatablesData<Pet> data = new ConvertedDatatablesData<Pet>(pets, totalPetsCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Owner owner, Model model) {
        populateForm(model);
        model.addAttribute("pet", new Pet());
        return new ModelAndView("owners/pets/create");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromPets", value = "/{petsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromPets(@ModelAttribute Owner owner, @PathVariable("petsToRemove") Long petsToRemove) {
        getOwnerService().removeFromPets(owner, Collections.singleton(petsToRemove));
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param petsToRemove
     * @return ResponseEntity
     */
    @DeleteMapping(name = "removeFromPetsBatch", value = "/batch/{petsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromPetsBatch(@ModelAttribute Owner owner, @PathVariable("petsToRemove") Collection<Long> petsToRemove) {
        getOwnerService().removeFromPets(owner, petsToRemove);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pets
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Owner owner, @RequestParam(value = "petsIds", required = false) List<Long> pets, @RequestParam("parentVersion") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (pets != null) {
            for (Iterator<Long> iterator = pets.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (version != owner.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (pets != null) {
                owner.setPets(new HashSet<Pet>(getPetService().findAll(pets)));
            } else {
                owner.setPets(new HashSet<Pet>());
            }
            // Reset the version to prevent update
            owner.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("owner", owner);
            model.addAttribute("concurrency", true);
            return new ModelAndView("owners/pets/create");
        } else if (version != owner.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("owner", owner);
            model.addAttribute("concurrency", false);
            return new ModelAndView("owners/pets/create");
        }
        getOwnerService().setPets(owner, pets);
        return new ModelAndView("redirect:" + getCollectionLink().to(OwnersCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
