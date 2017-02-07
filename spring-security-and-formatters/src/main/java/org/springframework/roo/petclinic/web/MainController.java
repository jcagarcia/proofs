package org.springframework.roo.petclinic.web;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.springlets.web.NotFoundException;

/**
 * = MainController
 *
 * TODO Auto-generated class documentation
 *
 */
@Controller
public class MainController {

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     * @return String
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        return "index";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     * @return String
     */
    @GetMapping("/accessibility")
    public String accessibility(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        return "accessibility";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param template
     * @return String
     */
    @RequestMapping(value = "/js/{template}.js", method = RequestMethod.GET)
    public String javascriptTemplates(@PathVariable("template") String template) {
        if (StringUtils.hasLength(template)) {
            return template.concat(".js");
        }
        throw new NotFoundException("File not found");
    }
}
