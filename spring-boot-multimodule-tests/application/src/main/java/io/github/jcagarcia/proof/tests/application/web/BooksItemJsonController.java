package io.github.jcagarcia.proof.tests.application.web;
import io.github.jcagarcia.proof.tests.model.domain.Book;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = BooksItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Book.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
public class BooksItemJsonController {
}
