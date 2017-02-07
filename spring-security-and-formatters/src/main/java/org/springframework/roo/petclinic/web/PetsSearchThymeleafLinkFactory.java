package org.springframework.roo.petclinic.web;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;

/**
 * = PetsSearchThymeleafLinkFactory
 *
 * TODO Auto-generated class documentation
 *
 */
@Component
public class PetsSearchThymeleafLinkFactory implements MethodLinkFactory<PetsSearchThymeleafController> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYNAMEANDWEIGHTDT = "byNameAndWeightDt";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYNAMEANDWEIGHT = "byNameAndWeight";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYNAMEANDWEIGHTFORM = "byNameAndWeightForm";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<PetsSearchThymeleafController> getControllerClass() {
        return PetsSearchThymeleafController.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param methodName
     * @param parameters
     * @param pathVariables
     * @return UriComponents
     */
    public UriComponents toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {
        if (methodName.equals(BYNAMEANDWEIGHTFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byNameAndWeightForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYNAMEANDWEIGHT)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byNameAndWeight(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYNAMEANDWEIGHTDT)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byNameAndWeightDt(null, null, null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
