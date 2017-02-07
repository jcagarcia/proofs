package org.springframework.roo.petclinic.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.petclinic.domain.Owner;
import org.springframework.roo.petclinic.domain.Pet;
import org.springframework.roo.petclinic.domain.reference.PetType;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = PetRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface PetRepository extends DetachableJpaRepository<Pet, Long>, PetRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @return Long
     */
    public abstract long countByOwner(Owner owner);

    /**
     * TODO Auto-generated method documentation
     *
     * @param owner
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findByOwner(Owner owner, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findBySendRemindersAndWeightLessThan(boolean sendReminders, Float weight, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param sendReminders
     * @param weight
     * @return Long
     */
    public abstract long countBySendRemindersAndWeightLessThan(boolean sendReminders, Float weight);

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findByTypeAndNameLike(PetType type, String name, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param type
     * @param name
     * @return Long
     */
    public abstract long countByTypeAndNameLike(PetType type, String name);
}
