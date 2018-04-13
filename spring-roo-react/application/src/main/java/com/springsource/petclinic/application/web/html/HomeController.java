package com.springsource.petclinic.application.web.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * = HomeController
 *
 * Controller that serves the home
 */
@Controller
public class HomeController {

    /**
     * Main method that serves the index page
     *
     * @return
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
