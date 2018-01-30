package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;
import org.springframework.roo.petclinic.dod.DataOnDemandConfiguration;
import org.springframework.roo.petclinic.domain.dod.PetDataOnDemand;

/**
 * = PetRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = PetRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = PetDataOnDemand.class)
public class PetRepositoryIT {
}
