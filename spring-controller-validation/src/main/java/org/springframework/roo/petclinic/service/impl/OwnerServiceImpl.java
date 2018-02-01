package org.springframework.roo.petclinic.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.roo.petclinic.domain.MessageI18n;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorization;
import org.springframework.roo.addon.security.annotations.RooSecurityAuthorizations;
import org.springframework.roo.petclinic.domain.Owner;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * = OwnerServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = OwnerService.class)
@RooSecurityAuthorizations(authorizations = { @RooSecurityAuthorization(method = "delete", parameters = { Owner.class }, roles = "ADMIN"), @RooSecurityAuthorization(method = "delete", parameters = { Iterable.class }, roles = "ADMIN") })
public class OwnerServiceImpl implements OwnerService<Owner> {


    /**
     * {@inheritDoc}
     *
     * @param name
     * @return
     */
    @Override
    public List<Owner> findByName(String name) {
        return getOwnerRepository().findByFirstName(name);
    }

    /**
     * {@inheritDoc}
     *
     * @param name The name of the pet that you are looking for.
     * @param exclusions The ids that want to be excluded from the validation
     * @return
     */
    @Override
    public boolean exists(String name, Long... exclusions) {
        // Obtain all the pets with the same name
        List<Owner> owners = findByName(name);
        if (exclusions.length > 0) {
            // Exclude the elements from the result list to prevent
            // wrong unique errors.
            owners = owners.stream().filter(
                    e -> !Arrays.asList(exclusions).contains(e.getId())
            ).collect(Collectors.toList());
        }

        if(!owners.isEmpty()){
            return true;
        }

        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param owner
     * @return
     */
    @Override
    public Map<String, List<MessageI18n>> validate(Owner owner) {
        String name = owner.getFirstName();
        Map<String, List<MessageI18n>> messages = new HashMap<>();

        // Check if name is empty
        if(StringUtils.isEmpty(name)) {
            messages.put("firstName", Arrays.asList(new MessageI18n("label_empty_error")));
        }else if(exists(name, owner.getId())) {
            messages.put("firstName", Arrays.asList(new MessageI18n("label_name_must_be_unique", name)));
        }

        // Check email
        if(StringUtils.isEmpty(owner.getEmail())){
            messages.put("email", Arrays.asList(new MessageI18n("label_empty_error")));
        }

        return messages;
    }
}
