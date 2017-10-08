package org.springframework.roo.petclinic.web;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.select2.Select2DataSupport;
import io.springlets.data.web.select2.Select2DataWithConversion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * = OwnersCollectionThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Owner.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class OwnersCollectionThymeleafController {

    /**
     * Updating generated method to obtain all the information from the Owner.
     *
     * @param search
     * @param pageable
     * @param locale
     * @return ResponseEntity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, name = "select2", value = "/s2")
    @ResponseBody
    public ResponseEntity<Select2DataSupport<Owner>> select2(GlobalSearch search, Pageable pageable, Locale locale) {
        Page<Owner> owners = getOwnerService().findAll(search, pageable);
        String idExpression = "#{id}";
        Select2DataSupport<Owner> select2Data = new Select2DataWithConversion<Owner>(owners, idExpression, getConversionService(), true);
        return ResponseEntity.ok(select2Data);
    }

}
