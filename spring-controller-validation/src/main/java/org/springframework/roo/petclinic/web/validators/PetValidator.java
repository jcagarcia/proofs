package org.springframework.roo.petclinic.web.validators;

import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * = PetValidator
 * <p>
 * Implementation of the {@link Validator} interface to be able to validate
 * the {@link Pet} entity during the Binding process.
 */
public class PetValidator implements Validator {

    /**
     * The service used to
     */
    private PetService petService;

    /**
     * Default constructor that receives the service to be able
     * to execute necessary operations during validation process.
     *
     * @param petService
     */
    public PetValidator(PetService petService) {
        Assert.notNull(petService, "ERROR: You must provide a valid service.");
        this.petService = petService;
    }

    /**
     * This Validator validates *just* Pet instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Pet.class.equals(clazz);
    }

    /**
     * The validation process of this element
     *
     * @param obj
     * @param errors
     */
    @Override
    public void validate(Object obj, Errors errors) {
        // Use the ValidationUtils to check if the name of the object is empty
        ValidationUtils.rejectIfEmpty(errors, "name", "label_empty_name");

        // Cast the object to the element that we know we're managing
        Pet pet = (Pet) obj;

        // If the pet name is not empty, check if unique among all the pets
        String name = pet.getName();
        if (!StringUtils.isEmpty(name)) {
            // Obtain all the pets with the same name
            List<Pet> pets = petService.findByName(name);
            // Exclude this provided element from the result list to prevent
            // wrong unique errors.
            List<Pet> petsWithSameName = pets.stream().filter(
                    e -> !Objects.equals(pet.getId(), e.getId())
            ).collect(Collectors.toList());

            // If exists one pet with the same name, reject an error for the field name
            if (!petsWithSameName.isEmpty()) {
                errors.rejectValue("name", "label_name_must_be_unique");
            }
        }

    }
}
