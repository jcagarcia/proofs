package io.jcagarcia.roles.division.application.config.jackson;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = DomainModelModule
 */
@JsonComponent
public class DomainModelModule extends SimpleModule {

    public DomainModelModule() {
        // Mixin registration
    }
}
