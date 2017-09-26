package io.github.jcagarcia.proof.tests.application.web;
import io.github.jcagarcia.proof.tests.model.domain.Library;
import io.github.jcagarcia.proof.tests.service.api.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

/**
 * = LibraryDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Library.class)
public class LibraryDeserializer extends JsonObjectDeserializer<Library> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private LibraryService libraryService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param libraryService
     * @param conversionService
     */
    @Autowired
    public LibraryDeserializer(@Lazy LibraryService libraryService, ConversionService conversionService) {
        this.libraryService = libraryService;
        this.conversionService = conversionService;
    }
}
