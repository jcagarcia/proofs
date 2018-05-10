package io.github.jcagarcia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import io.github.jcagarcia.domain.enumeration.PetType;

/**
 * A Pet.
 */
@Entity
@Table(name = "pet")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "send_reminders")
    private Boolean sendReminders;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Float weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "pet_type")
    private PetType petType;

    @OneToMany(mappedBy = "pet")
    @JsonIgnore
    private Set<Owner> owners = new HashSet<>();

    @ManyToOne
    private Visit visit;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isSendReminders() {
        return sendReminders;
    }

    public Pet sendReminders(Boolean sendReminders) {
        this.sendReminders = sendReminders;
        return this;
    }

    public void setSendReminders(Boolean sendReminders) {
        this.sendReminders = sendReminders;
    }

    public String getName() {
        return name;
    }

    public Pet name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeight() {
        return weight;
    }

    public Pet weight(Float weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public PetType getPetType() {
        return petType;
    }

    public Pet petType(PetType petType) {
        this.petType = petType;
        return this;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public Pet owners(Set<Owner> owners) {
        this.owners = owners;
        return this;
    }

    public Pet addOwner(Owner owner) {
        this.owners.add(owner);
        owner.setPet(this);
        return this;
    }

    public Pet removeOwner(Owner owner) {
        this.owners.remove(owner);
        owner.setPet(null);
        return this;
    }

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

    public Visit getVisit() {
        return visit;
    }

    public Pet visit(Visit visit) {
        this.visit = visit;
        return this;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pet pet = (Pet) o;
        if (pet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), pet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Pet{" +
            "id=" + getId() +
            ", sendReminders='" + isSendReminders() + "'" +
            ", name='" + getName() + "'" +
            ", weight=" + getWeight() +
            ", petType='" + getPetType() + "'" +
            "}";
    }
}
