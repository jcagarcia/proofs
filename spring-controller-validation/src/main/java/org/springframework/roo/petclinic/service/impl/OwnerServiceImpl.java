package org.springframework.roo.petclinic.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorization;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorizations;
import org.springframework.roo.petclinic.domain.Owner;

/**
 * = OwnerServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = OwnerService.class)
@RooSecurityAuthorizations(authorizations = { @RooSecurityAuthorization(method = "delete", parameters = { Owner.class }, roles = "ADMIN"), @RooSecurityAuthorization(method = "delete", parameters = { Iterable.class }, roles = "ADMIN") })
public class OwnerServiceImpl implements OwnerService {
}
