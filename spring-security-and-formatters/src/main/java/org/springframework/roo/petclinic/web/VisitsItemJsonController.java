package org.springframework.roo.petclinic.web;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Visit;
import org.springframework.roo.petclinic.service.api.VisitService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;

/**
 * = VisitsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/visits/{visit}", name = "VisitsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitsItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VisitService visitService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param visitService
     */
    @Autowired
    public VisitsItemJsonController(VisitService visitService) {
        this.visitService = visitService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VisitService
     */
    public VisitService getVisitService() {
        return visitService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visitService
     */
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Visit
     */
    @ModelAttribute
    public Visit getVisit(@PathVariable("visit") Long id) {
        Visit visit = visitService.findOne(id);
        if (visit == null) {
            throw new NotFoundException(String.format("Visit with identifier '%s' not found", id));
        }
        return visit;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Visit visit) {
        return ResponseEntity.ok(visit);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @return UriComponents
     */
    public static UriComponents showURI(Visit visit) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(VisitsItemJsonController.class).show(visit)).buildAndExpand(visit.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedVisit
     * @param visit
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Visit storedVisit, @Valid @RequestBody Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        visit.setId(storedVisit.getId());
        getVisitService().save(visit);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param visit
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Visit visit) {
        getVisitService().delete(visit);
        return ResponseEntity.ok().build();
    }
}
