package org.springframework.roo.petclinic.domain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import io.springlets.format.EntityFormat;

/**
 * = OwnerInfo
 *
 * TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class OwnerInfo {

    private Long id;

    @Size(min = 3, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    @NotNull
    @Size(max = 30)
    private String city;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param city
     */
    public OwnerInfo(Long id, String firstName, String lastName, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof OwnerInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        OwnerInfo rhs = (OwnerInfo) obj;
        return new EqualsBuilder().append(city, rhs.city).append(firstName, rhs.firstName).append(id, rhs.id).append(lastName, rhs.lastName).isEquals();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public int hashCode() {
        return new HashCodeBuilder().append(city).append(firstName).append(id).append(lastName).toHashCode();
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
     * @return String
     */
    public String getCity() {
        return this.city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "OwnerInfo {" + "id='" + id + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", city='" + city + '\'' + "}" + super.toString();
    }
}
