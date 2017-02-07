package org.springframework.roo.petclinic.web;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.domain.Vet;
import org.springframework.roo.petclinic.service.api.VetService;
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
 * = VetsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/vets/{vet}", name = "VetsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class VetsItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private VetService vetService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param vetService
     */
    @Autowired
    public VetsItemJsonController(VetService vetService) {
        this.vetService = vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return VetService
     */
    public VetService getVetService() {
        return vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vetService
     */
    public void setVetService(VetService vetService) {
        this.vetService = vetService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Vet
     */
    @ModelAttribute
    public Vet getVet(@PathVariable("vet") Long id) {
        Vet vet = vetService.findOne(id);
        if (vet == null) {
            throw new NotFoundException(String.format("Vet with identifier '%s' not found", id));
        }
        return vet;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Vet vet) {
        return ResponseEntity.ok(vet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @return UriComponents
     */
    public static UriComponents showURI(Vet vet) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(VetsItemJsonController.class).show(vet)).buildAndExpand(vet.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedVet
     * @param vet
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Vet storedVet, @Valid @RequestBody Vet vet, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        vet.setId(storedVet.getId());
        getVetService().save(vet);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param vet
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Vet vet) {
        getVetService().delete(vet);
        return ResponseEntity.ok().build();
    }
}
