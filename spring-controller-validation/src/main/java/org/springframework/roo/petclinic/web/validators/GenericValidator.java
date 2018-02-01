package org.springframework.roo.petclinic.web.validators;

import org.springframework.roo.petclinic.domain.MessageI18n;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.roo.petclinic.service.api.ValidatorService;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Map;

/**
 * = GenericValidator
 * <p>
 * Implementation of the {@link Validator} interface to be able to validate
 * all the entities during the Binding process.
 */
public class GenericValidator<T> implements Validator {

    /**
     * The service used to validate
     */
    private ValidatorService validatorService;

    /**
     * Default constructor that receives the service to be able
     * to execute necessary operations during validation process.
     *
     * @param validatorService
     */
    public GenericValidator(T validatorService) {
        Assert.notNull(validatorService, "ERROR: You must provide a valid Validator service.");
        this.validatorService = (ValidatorService) validatorService;
    }

    /**
     * This Validator validates all type of instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * The validation process of this element
     *
     * @param obj
     * @param errors
     */
    @Override
    public void validate(Object obj, Errors errors) {
        Map<String, List<MessageI18n>> messages = validatorService.validate(obj);
        messages.forEach((k,v)-> {
            v.forEach((e) -> {
                errors.rejectValue(k, e.label, e.values, "");
            });
        });
    }
}
