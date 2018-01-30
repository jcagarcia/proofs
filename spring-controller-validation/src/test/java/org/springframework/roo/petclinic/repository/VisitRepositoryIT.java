package org.springframework.roo.petclinic.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;
import org.springframework.roo.petclinic.dod.DataOnDemandConfiguration;
import org.springframework.roo.petclinic.domain.dod.VisitDataOnDemand;

/**
 * = VisitRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = VisitRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = VisitDataOnDemand.class)
public class VisitRepositoryIT {
}
