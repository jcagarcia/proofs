package org.springframework.roo.petclinic.domain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.roo.petclinic.domain.reference.Specialty;

import io.springlets.format.EntityFormat;

/**
 * = VetInfo
 *
 * TODO Auto-generated class documentation
 *
 */
@EntityFormat("#{firstName} #{lastName}")
public class VetInfo {

    private Long id;

    @Size(min = 3, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    private Specialty specialty;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param specialty
     */
    public VetInfo(Long id, String firstName, String lastName, Specialty specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof VetInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VetInfo rhs = (VetInfo) obj;
        return new EqualsBuilder().append(firstName, rhs.firstName).append(id, rhs.id).append(lastName, rhs.lastName).append(specialty, rhs.specialty).isEquals();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(id).append(lastName).append(specialty).toHashCode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Specialty
     */
    public Specialty getSpecialty() {
        return this.specialty;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "VetInfo {" + "id='" + id + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + "}" + super.toString();
    }
}
