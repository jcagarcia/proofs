package org.springframework.roo.petclinic.web;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface ConcurrencyCallback<T> {

    ModelAndView save(Object item);

    ModelAndView exception(Object item, Model model);
}
