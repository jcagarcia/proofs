package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;
import org.springframework.roo.petclinic.dod.DataOnDemandConfiguration;
import org.springframework.roo.petclinic.domain.dod.OwnerDataOnDemand;

/**
 * = OwnerRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = OwnerRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = OwnerDataOnDemand.class)
public class OwnerRepositoryIT {
}
