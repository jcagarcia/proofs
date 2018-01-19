package org.springframework.roo.petclinic.config;
import org.springframework.roo.addon.ws.annotations.RooWsEndpoints;
import org.springframework.roo.petclinic.ws.endpoint.OwnerWebServiceEndpoint;
import org.springframework.roo.petclinic.ws.endpoint.PetWebServiceEndpoint;

/**
 * = WsEndpointsConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
@RooWsEndpoints(endpoints = { OwnerWebServiceEndpoint.class, PetWebServiceEndpoint.class })
public class WsEndpointsConfiguration {
}
