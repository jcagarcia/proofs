package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.roo.petclinic.domain.Owner;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.petclinic.service.api.OwnerService;
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

/**
 * = OwnersItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Owner.class, type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/owners/{owner}", name = "OwnersItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class OwnersItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OwnerService ownerService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param ownerService
     */
    @Autowired
    public OwnersItemJsonController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OwnerService
     */
    public OwnerService getOwnerService() {
        return ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ownerService
     */
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Owner
     */
    @ModelAttribute
    public Owner getOwner(@PathVariable("owner") Long id) {
        Owner owner = ownerService.findOne(id);
        if (owner == null) {
            throw new NotFoundException(String.format("Owner with identifier '%s' not found", id));
        }
        return owner;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Owner owner) {
        return ResponseEntity.ok(owner);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return UriComponents
     */
    public static UriComponents showURI(Owner owner) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(OwnersItemJsonController.class).show(owner)).buildAndExpand(owner.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedOwner
     * @param owner
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Owner storedOwner, @Valid @RequestBody Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        owner.setId(storedOwner.getId());
        getOwnerService().save(owner);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Owner owner) {
        getOwnerService().delete(owner);
        return ResponseEntity.ok().build();
    }
}
