package org.springframework.roo.petclinic.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.accept.ContentNegotiationStrategy;

/**
 * = Security configuration
 *
 * Configuration class for subjects related to the security layer of the
 * application.
 */
@Configuration
@EnableGlobalMethodSecurity( prePostEnabled = true, securedEnabled = true )
@EnableWebSecurity
public class SecurityConfiguration
{

  /**
   * Default configuration for development environment.
   */
  @Configuration
  protected static class WebSecurityConfigDev extends WebSecurityConfigurerAdapter
  {

    /**
     * Default security configuration for development environment. This disallows
     * the login.
     */
    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
      // Authentication is disabled for development environment
      http.authorizeRequests().antMatchers( "/**" ).permitAll();
    }
    
    /**
     * FIX ME!! By default, this method provided by {@link WebSecurityConfigurerAdapter}
     * is annotated with @Autowired. That causes that the {@link ContentNegotiationStrategy}
     * load process registers a ConversionService before the Formatters have been registered
     * in the Spring Context.
     * 
     * To solve this, override the default method removing the @Autowired annotation
     * to be able to load the Formatters before the Conversion Service register
     * them.
     * 
     * This doesn't seem to be a good solution...
     * 
     */
    /*@Override
  	public void setContentNegotationStrategy(
  			ContentNegotiationStrategy contentNegotiationStrategy) {
    	super.setContentNegotationStrategy(contentNegotiationStrategy);
  	}*/
    
  }

}
