package org.springframework.roo.petclinic.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Controller advice that adds the {@link CollectionValidator} to the {@link WebDataBinder}.
 * 
 */
@ControllerAdvice
public class ValidatorAdvice {

  @Autowired
  protected CollectionValidator collectionValidator;

  /**
   * Adds the {@link CollectionValidator} to the supplied {@link WebDataBinder}
   * 
   * @param binder web data binder.
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    Object target = binder.getTarget();
    if (target != null && collectionValidator.supports(target.getClass())) {
      binder.addValidators(collectionValidator);
    }
  }
}