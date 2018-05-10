package io.github.jcagarcia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Visit.
 */
@Entity
@Table(name = "visit")
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "visit_date")
    private String visitDate;

    @OneToMany(mappedBy = "visit")
    @JsonIgnore
    private Set<Pet> pets = new HashSet<>();

    @OneToMany(mappedBy = "visit")
    @JsonIgnore
    private Set<Vet> vets = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Visit description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public Visit visitDate(String visitDate) {
        this.visitDate = visitDate;
        return this;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public Visit pets(Set<Pet> pets) {
        this.pets = pets;
        return this;
    }

    public Visit addPet(Pet pet) {
        this.pets.add(pet);
        pet.setVisit(this);
        return this;
    }

    public Visit removePet(Pet pet) {
        this.pets.remove(pet);
        pet.setVisit(null);
        return this;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Vet> getVets() {
        return vets;
    }

    public Visit vets(Set<Vet> vets) {
        this.vets = vets;
        return this;
    }

    public Visit addVet(Vet vet) {
        this.vets.add(vet);
        vet.setVisit(this);
        return this;
    }

    public Visit removeVet(Vet vet) {
        this.vets.remove(vet);
        vet.setVisit(null);
        return this;
    }

    public void setVets(Set<Vet> vets) {
        this.vets = vets;
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
        Visit visit = (Visit) o;
        if (visit.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), visit.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Visit{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", visitDate='" + getVisitDate() + "'" +
            "}";
    }
}
