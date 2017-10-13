package io.jcagarcia.roles.division.model.domain;
import io.springlets.format.EntityFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

/**
 * = Employee
 */
@Entity
@EntityFormat
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Integer version;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date since;

    @NotNull
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This `equals` implementation is specific for JPA entities and uses
     * the entity identifier for it, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Employee)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Employee) obj).getId());
    }

    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able
     * to identify the entity in collections after a new id is assigned to the entity, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Employee {" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' + "}" + super.toString();
    }
}
