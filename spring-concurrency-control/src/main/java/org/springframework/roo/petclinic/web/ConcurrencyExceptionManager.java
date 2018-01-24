package org.springframework.roo.petclinic.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * = ConcurrencyExceptionManager
 * <p>
 * Controller Advice that monitorizes all the existing @Controller's and catch
 * all the {@link ConcurrencyException} that could appear.
 */
@ControllerAdvice
public class ConcurrencyExceptionManager {

    /**
     * ExceptionHandler that manages the {@link ConcurrencyException}. Using the information
     * available inside the {@link ConcurrencyException} object, it delegates in the manager
     * that throws the exception to populate the concurrency form and to return a valid view.
     * <p>
     * The controller is the only one who knows how to manage the concurrency. Also, it allow us to
     * customize the default behaviour of the concurrency exception feature.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ConcurrencyException.class)
    public ModelAndView concurrencyException(final ConcurrencyException ex) {
        return ex.getManager().populateConcurrencyForm(ex.getRecord(), ex.getModel());
    }


}
