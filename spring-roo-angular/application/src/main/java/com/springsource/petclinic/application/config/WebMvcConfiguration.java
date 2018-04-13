package com.springsource.petclinic.application.config;
import org.springframework.context.annotation.Bean;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooWebMvcConfiguration;
import org.springframework.context.ApplicationContextAware;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooWebMvcThymeleafUIConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * = WebMvcConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
@RooWebMvcConfiguration(defaultLanguage = "en")
@RooWebMvcThymeleafUIConfiguration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter
        implements ApplicationContextAware  {

    /**
     * Resolver javascript files in templates folder
     *
     * @return
     */
    @Bean
    public SpringResourceTemplateResolver javascriptTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(getApplicationContext());
        resolver.setPrefix("classpath:/templates/");
        resolver.setTemplateMode(TemplateMode.RAW);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCheckExistence(true);
        resolver.setCacheable(getThymeleafProperties().isCache());
        return resolver;
    }

    /**
     * Resolve javascript views
     *
     * @return ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver javascriptThymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(getTemplateEngine());
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("application/javascript");
        resolver.setViewNames(new String[] {"*.js"});
        resolver.setCache(getThymeleafProperties().isCache());
        return resolver;
    }
}
