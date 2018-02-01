package org.springframework.roo.petclinic.service.impl;

import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.roo.petclinic.domain.MessageI18n;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.validation.ValidationUtils;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * = PetServiceImpl
 * <p>
 * TODO Auto-generated class documentation
 */
@RooServiceImpl(service = PetService.class)
public class PetServiceImpl implements PetService {

    /**
     * {@inheritDoc}
     *
     * @param name
     * @return
     */
    @Override
    public List<Pet> findByName(String name) {
        return getPetRepository().findByName(name);
    }

    /**
     * {@inheritDoc}
     *
     * @param name       The name of the pet that you are looking for.
     * @param exclusions The ids that want to be excluded from the validation
     * @return
     */
    @Override
    public boolean exists(String name, Long... exclusions) {
        // Obtain all the pets with the same name
        List<Pet> pets = findByName(name);
        if (exclusions.length > 0) {
            // Exclude the elements from the result list to prevent
            // wrong unique errors.
            pets = pets.stream().filter(
                    e -> !Arrays.asList(exclusions).contains(e.getId())
            ).collect(Collectors.toList());
        }

        if(!pets.isEmpty()){
            return true;
        }

        return false;

    }

    /**
     * Implements validate method to validate the Pet entity
     *
     * @param pet
     * @return
     */
    @Override
    public Map<String, List<MessageI18n>> validate(Pet pet) {

        String name = pet.getName();
        Map<String, List<MessageI18n>> messages = new HashMap<>();

        // Check if name is empty
        if(StringUtils.isEmpty(name)) {
            messages.put("name", Arrays.asList(new MessageI18n("label_empty_name")));
        }else if(exists(name, pet.getId())) {
            messages.put("name", Arrays.asList(new MessageI18n("label_name_must_be_unique", name)));
        }

        return messages;
    }
}
