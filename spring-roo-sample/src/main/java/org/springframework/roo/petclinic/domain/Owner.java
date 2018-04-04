package org.springframework.roo.petclinic.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.jpa.annotations.audit.RooJpaAudit;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import io.springlets.format.EntityFormat;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.Assert;

/**
 * = Owner
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{lastName} (#{city})")
@RooJpaAudit
@RooJaxbEntity
@EntityListeners(AuditingEntityListener.class)
@Entity
@EntityFormat("#{lastName} (#{city})")
@XmlRootElement(name = "owner", namespace = "http://ws.petclinic.roo.springframework.org/")
public class Owner extends AbstractPerson {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "owner")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Pet> pets = new HashSet<Pet>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar createdDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @CreatedBy
    private String createdBy;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar modifiedDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @LastModifiedBy
    private String modifiedBy;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Pet> getPets() {
        return this.pets;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pets
     */
    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getCreatedDate() {
        return this.createdDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param createdDate
     */
    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Calendar
     */
    public Calendar getModifiedDate() {
        return this.modifiedDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param modifiedDate
     */
    public void setModifiedDate(Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param modifiedBy
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Owner {" + "createdDate='" + createdDate + '\'' + ", createdBy='" + createdBy + '\'' + ", modifiedDate='" + modifiedDate + '\'' + ", modifiedBy='" + modifiedBy + '\'' + ", ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE + '\'' + ", ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE='" + ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petsToAdd
     */
    public void addToPets(Iterable<Pet> petsToAdd) {
        Assert.notNull(petsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Pet item : petsToAdd) {
            this.pets.add(item);
            item.setOwner(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petsToRemove
     */
    public void removeFromPets(Iterable<Pet> petsToRemove) {
        Assert.notNull(petsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Pet item : petsToRemove) {
            this.pets.remove(item);
            item.setOwner(null);
        }
    }
}
