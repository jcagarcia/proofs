package com.springsource.petclinic.application.web.html;

import io.springlets.web.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller that serves the angular application
 */
@Controller
public class MainController {

    /**
     * Serves the Angular Application
     *
     * @return
     */
    @RequestMapping(value = "/**")
    public String angularApp(){
        return "index";
    }

    /**
     * Serves the .ico files inside the templates folder
     *
     * @param template
     * @return
     */
    @RequestMapping(value = "/{template}.ico", method = RequestMethod.GET)
    public String icoTemplates(@PathVariable("template") String template) {
        if (StringUtils.hasLength(template)) {
            return template.concat(".ico");
        }
        throw new NotFoundException("File not found");
    }

    /**
     * Serve the .css files inside the templates folder
     *
     * @param template
     * @return
     */
    @RequestMapping(value = "/{template}.css", method = RequestMethod.GET)
    public String cssTemplates(@PathVariable("template") String template) {
        if (StringUtils.hasLength(template)) {
            return template.concat(".css");
        }
        throw new NotFoundException("File not found");
    }

    /**
     * Serve the .js files inside the templates folder
     *
     * @param template
     * @return
     */
    @RequestMapping(value = "/{template}.js", method = RequestMethod.GET)
    public String javascriptTemplates(@PathVariable("template") String template) {
        if (StringUtils.hasLength(template)) {
            return template.concat(".js");
        }
        throw new NotFoundException("File not found");
    }

}
