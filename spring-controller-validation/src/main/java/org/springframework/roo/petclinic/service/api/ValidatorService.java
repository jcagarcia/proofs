package org.springframework.roo.petclinic.service.api;

import org.springframework.roo.petclinic.domain.MessageI18n;

import java.util.List;
import java.util.Map;

/**
 * = ValidatorService
 *
 * API that defines operations to validate entities
 * @param <T> Entity that will be validated
 */
public interface ValidatorService<T> {

    /**
     * Defines an operation to validate the provided entity.
     *
     * @param entity
     * @return
     */
    Map<String, List<MessageI18n>> validate(T entity);


}
