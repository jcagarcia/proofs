package io.github.jcagarcia.springbootgraphql.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main Controller that contains initial operations
 */
@RestController
public class MainController {

    /**
     * Welcome method
     *
     * @return
     */
    @GetMapping
    public String welcome(){
        return "Welcome to the `We Travel` REST API";
    }
}
