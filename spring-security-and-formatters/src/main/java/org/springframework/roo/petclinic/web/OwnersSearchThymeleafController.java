package org.springframework.roo.petclinic.web;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.OwnerCityFormBean;
import org.springframework.roo.petclinic.domain.OwnerFirstNameFormBean;
import org.springframework.roo.petclinic.domain.OwnerInfo;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesData;
import io.springlets.data.web.datatables.DatatablesPageable;

/**
 * = OwnersSearchThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/owners/search", name = "OwnersSearchThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class OwnersSearchThymeleafController {

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
     * TODO Auto-generated constructor documentation
     *
     * @param ownerService
     * @param messageSource
     */
    @Autowired
    public OwnersSearchThymeleafController(OwnerService ownerService, MessageSource messageSource) {
        setOwnerService(ownerService);
        setMessageSource(messageSource);
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
     * @param formBean
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "byFirstNameLikeForm", value = "/byFirstNameLike/search-form")
    public ModelAndView byFirstNameLikeForm(@ModelAttribute("formBean") OwnerFirstNameFormBean formBean, Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        return new ModelAndView("owners/findByFirstNameLikeForm");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "byFirstNameLike", value = "/byFirstNameLike")
    public ModelAndView byFirstNameLike(@ModelAttribute("formBean") OwnerFirstNameFormBean formBean, Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        return new ModelAndView("owners/findByFirstNameLike");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "byFirstNameLikeDt", value = "/byFirstNameLike/dt", produces = Datatables.MEDIA_TYPE)
    @ResponseBody
    public ResponseEntity<DatatablesData<Owner>> byFirstNameLikeDt(@ModelAttribute("formBean") OwnerFirstNameFormBean formBean, GlobalSearch search, DatatablesPageable pageable, @RequestParam(Datatables.PARAMETER_DRAW) Integer draw) {
        Page<Owner> owners = getOwnerService().findByFirstNameLike(formBean, search, pageable);
        long totalOwnersCount = owners.getTotalElements();
        if (search != null && StringUtils.isNotBlank(search.getText())) {
            totalOwnersCount = getOwnerService().countByFirstNameLike(formBean);
        }
        DatatablesData<Owner> datatablesData = new DatatablesData<Owner>(owners, totalOwnersCount, draw);
        return ResponseEntity.ok(datatablesData);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "byCityLikeForm", value = "/byCityLike/search-form")
    public ModelAndView byCityLikeForm(@ModelAttribute("formBean") OwnerCityFormBean formBean, Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        return new ModelAndView("owners/findByCityLikeForm");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "byCityLike", value = "/byCityLike")
    public ModelAndView byCityLike(@ModelAttribute("formBean") OwnerCityFormBean formBean, Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        return new ModelAndView("owners/findByCityLike");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "byCityLikeDt", value = "/byCityLike/dt", produces = Datatables.MEDIA_TYPE)
    @ResponseBody
    public ResponseEntity<DatatablesData<OwnerInfo>> byCityLikeDt(@ModelAttribute("formBean") OwnerCityFormBean formBean, GlobalSearch search, DatatablesPageable pageable, @RequestParam(Datatables.PARAMETER_DRAW) Integer draw) {
        Page<OwnerInfo> owners = getOwnerService().findByCityLike(formBean, search, pageable);
        long totalOwnersCount = owners.getTotalElements();
        if (search != null && StringUtils.isNotBlank(search.getText())) {
            totalOwnersCount = getOwnerService().countByCityLike(formBean);
        }
        DatatablesData<OwnerInfo> datatablesData = new DatatablesData<OwnerInfo>(owners, totalOwnersCount, draw);
        return ResponseEntity.ok(datatablesData);
    }
}
