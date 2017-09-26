package io.github.jcagarcia.proof.tests.application.web;
import io.github.jcagarcia.proof.tests.model.domain.Book;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;

/**
 * = BooksCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Book.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
public class BooksCollectionJsonController {
}
