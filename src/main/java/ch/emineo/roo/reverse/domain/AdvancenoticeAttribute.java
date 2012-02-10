package ch.emineo.roo.reverse.domain;

import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@Table(name = "advancenotice_attribute")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = AdvancenoticeAttributePK.class, versionField = "", table = "advancenotice_attribute")
@RooDbManaged(automaticallyDelete = true)
public class AdvancenoticeAttribute {

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	@ManyToOne
    @JoinColumn(name = "ADVANCENOTICE_ADVANCENOTICEID", referencedColumnName = "ADVANCENOTICEID", nullable = false, insertable = false, updatable = false)
    private Advancenotice advancenoticeAdvancenoticeid;

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	public Advancenotice getAdvancenoticeAdvancenoticeid() {
        return advancenoticeAdvancenoticeid;
    }

	public void setAdvancenoticeAdvancenoticeid(Advancenotice advancenoticeAdvancenoticeid) {
        this.advancenoticeAdvancenoticeid = advancenoticeAdvancenoticeid;
    }

	@EmbeddedId
    private AdvancenoticeAttributePK id;

	public AdvancenoticeAttributePK getId() {
        return this.id;
    }

	public void setId(AdvancenoticeAttributePK id) {
        this.id = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new AdvancenoticeAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAdvancenoticeAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM AdvancenoticeAttribute o", Long.class).getSingleResult();
    }

	public static List<AdvancenoticeAttribute> findAllAdvancenoticeAttributes() {
        return entityManager().createQuery("SELECT o FROM AdvancenoticeAttribute o", AdvancenoticeAttribute.class).getResultList();
    }

	public static AdvancenoticeAttribute findAdvancenoticeAttribute(AdvancenoticeAttributePK id) {
        if (id == null) return null;
        return entityManager().find(AdvancenoticeAttribute.class, id);
    }

	public static List<AdvancenoticeAttribute> findAdvancenoticeAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM AdvancenoticeAttribute o", AdvancenoticeAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            AdvancenoticeAttribute attached = AdvancenoticeAttribute.findAdvancenoticeAttribute(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public AdvancenoticeAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        AdvancenoticeAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
