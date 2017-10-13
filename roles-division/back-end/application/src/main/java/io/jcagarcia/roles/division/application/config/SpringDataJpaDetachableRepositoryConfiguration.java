package io.jcagarcia.roles.division.application.config;
import io.jcagarcia.roles.division.DivisionApplication;
import io.springlets.data.jpa.repository.support.DetachableJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * = SpringDataJpaDetachableRepositoryConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = DetachableJpaRepositoryImpl.class, basePackageClasses = DivisionApplication.class)
public class SpringDataJpaDetachableRepositoryConfiguration {
}
