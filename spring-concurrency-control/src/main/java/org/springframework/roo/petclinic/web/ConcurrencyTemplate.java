package org.springframework.roo.petclinic.web;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class ConcurrencyTemplate {

    private Object item;
    private Model model;

    public ConcurrencyTemplate() {
        // Nothing to do here
    }

    public ConcurrencyTemplate(Object item, Model model){
        this.item = item;
        this.model = model;
    }

    public ModelAndView execute(ConcurrencyCallback action) {
        try {
            return action.execute(item);
        } catch (ObjectOptimisticLockingFailureException ex) {
            return action.concurrencyException(item, model);
        }
    }

}
