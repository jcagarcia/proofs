package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;
import org.springframework.roo.petclinic.dod.DataOnDemandConfiguration;
import org.springframework.roo.petclinic.domain.dod.VetDataOnDemand;

/**
 * = VetRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = VetRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = VetDataOnDemand.class)
public class VetRepositoryIT {
}
