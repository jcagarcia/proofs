package org.springframework.roo.petclinic.config;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.roo.petclinic.PetclinicApplication;

import io.springlets.data.jpa.repository.support.DetachableJpaRepositoryImpl;

/**
 * = SpringDataJpaDetachableRepositoryConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = DetachableJpaRepositoryImpl.class, basePackageClasses = PetclinicApplication.class)
@EntityScan(basePackageClasses = PetclinicApplication.class)
public class SpringDataJpaDetachableRepositoryConfiguration {
}
