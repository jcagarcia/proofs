package org.springframework.roo.petclinic.web;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

/**
 * = OwnersSearchThymeleafLinkFactory
 *
 * TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = OwnersSearchThymeleafController.class)
@Component
public class OwnersSearchThymeleafLinkFactory implements MethodLinkFactory<OwnersSearchThymeleafController> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYFIRSTNAMELIKEDT = "byFirstNameLikeDt";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYCITYLIKEFORM = "byCityLikeForm";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYFIRSTNAMELIKE = "byFirstNameLike";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYCITYLIKE = "byCityLike";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYCITYLIKEDT = "byCityLikeDt";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYFIRSTNAMELIKEFORM = "byFirstNameLikeForm";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<OwnersSearchThymeleafController> getControllerClass() {
        return OwnersSearchThymeleafController.class;
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
        if (methodName.equals(BYFIRSTNAMELIKEFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byFirstNameLikeForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYFIRSTNAMELIKE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byFirstNameLike(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYFIRSTNAMELIKEDT)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byFirstNameLikeDt(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYCITYLIKEFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byCityLikeForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYCITYLIKE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byCityLike(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYCITYLIKEDT)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byCityLikeDt(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
