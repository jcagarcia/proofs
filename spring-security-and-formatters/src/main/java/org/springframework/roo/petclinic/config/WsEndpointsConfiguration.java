package org.springframework.roo.petclinic.config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.roo.petclinic.service.api.OwnerService;
import org.springframework.roo.petclinic.service.api.PetService;
import org.springframework.roo.petclinic.ws.endpoint.OwnerWebServiceEndpoint;
import org.springframework.roo.petclinic.ws.endpoint.PetWebServiceEndpoint;

import io.tracee.binding.cxf.TraceeCxfFeature;

/**
 * = WsEndpointsConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
@Configuration
@ConditionalOnWebApplication
public class WsEndpointsConfiguration {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Autowired
    private Bus bus;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Autowired
    private PetService petService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Autowired
    private OwnerService ownerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Value("${cxf.path}")
    private String cxfServletPath;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WsEndpointsConfiguration.class);

    /**
     * TODO Auto-generated method documentation
     *
     * @return Logger
     */
    public Logger getLOGGER() {
        return LOGGER;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Bus
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCxfServletPath() {
        return cxfServletPath;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cxfServletPath
     */
    public void setCxfServletPath(String cxfServletPath) {
        this.cxfServletPath = cxfServletPath;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OwnerService
     */
    public OwnerService getOwnerService() {
        return ownerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Endpoint
     */
    @Bean
    public Endpoint ownerWebServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(getBus(), new OwnerWebServiceEndpoint(getOwnerService()));
        endpoint.setFeatures(Arrays.asList(new TraceeCxfFeature(), new LoggingFeature()));
        endpoint.publish("/OwnerWebService");
        return endpoint;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PetService
     */
    public PetService getPetService() {
        return petService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Endpoint
     */
    @Bean
    public Endpoint petWebServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(getBus(), new PetWebServiceEndpoint(getPetService()));
        endpoint.setFeatures(Arrays.asList(new TraceeCxfFeature(), new LoggingFeature()));
        endpoint.publish("/PetWebService");
        return endpoint;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean openEntityManagerInViewFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new OpenEntityManagerInViewFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add(getCxfServletPath() + "/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        if (getLOGGER().isDebugEnabled()) {
            getLOGGER().debug("Registering the 'OpenEntityManagerInViewFilter' filter for the '".concat(getCxfServletPath() + "/*").concat("' URL."));
        }
        return filterRegBean;
    }
}
