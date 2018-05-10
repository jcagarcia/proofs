package io.github.jcagarcia.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import io.github.jcagarcia.domain.enumeration.Speciality;

/**
 * A Vet.
 */
@Entity
@Table(name = "vet")
public class Vet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "home_page")
    private String homePage;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "employee_since")
    private String employeeSince;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality")
    private Speciality speciality;

    @ManyToOne
    private Visit visit;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Vet firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Vet lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public Vet address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public Vet city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public Vet telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHomePage() {
        return homePage;
    }

    public Vet homePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getEmail() {
        return email;
    }

    public Vet email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Vet birthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmployeeSince() {
        return employeeSince;
    }

    public Vet employeeSince(String employeeSince) {
        this.employeeSince = employeeSince;
        return this;
    }

    public void setEmployeeSince(String employeeSince) {
        this.employeeSince = employeeSince;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public Vet speciality(Speciality speciality) {
        this.speciality = speciality;
        return this;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Visit getVisit() {
        return visit;
    }

    public Vet visit(Visit visit) {
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
        Vet vet = (Vet) o;
        if (vet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Vet{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", address='" + getAddress() + "'" +
            ", city='" + getCity() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", homePage='" + getHomePage() + "'" +
            ", email='" + getEmail() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", employeeSince='" + getEmployeeSince() + "'" +
            ", speciality='" + getSpeciality() + "'" +
            "}";
    }
}
