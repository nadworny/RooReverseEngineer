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
@Table(name = "subscriptiontype_attribute")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = SubscriptiontypeAttributePK.class, versionField = "", table = "subscriptiontype_attribute")
@RooDbManaged(automaticallyDelete = true)
public class SubscriptiontypeAttribute {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@EmbeddedId
    private SubscriptiontypeAttributePK id;

	public SubscriptiontypeAttributePK getId() {
        return this.id;
    }

	public void setId(SubscriptiontypeAttributePK id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "SUBSCRIPTIONTYPE_MONTHS", referencedColumnName = "MONTHS", nullable = false, insertable = false, updatable = false)
    private Subscriptiontype subscriptiontypeMonths;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Subscriptiontype getSubscriptiontypeMonths() {
        return subscriptiontypeMonths;
    }

	public void setSubscriptiontypeMonths(Subscriptiontype subscriptiontypeMonths) {
        this.subscriptiontypeMonths = subscriptiontypeMonths;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new SubscriptiontypeAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countSubscriptiontypeAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SubscriptiontypeAttribute o", Long.class).getSingleResult();
    }

	public static List<SubscriptiontypeAttribute> findAllSubscriptiontypeAttributes() {
        return entityManager().createQuery("SELECT o FROM SubscriptiontypeAttribute o", SubscriptiontypeAttribute.class).getResultList();
    }

	public static SubscriptiontypeAttribute findSubscriptiontypeAttribute(SubscriptiontypeAttributePK id) {
        if (id == null) return null;
        return entityManager().find(SubscriptiontypeAttribute.class, id);
    }

	public static List<SubscriptiontypeAttribute> findSubscriptiontypeAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SubscriptiontypeAttribute o", SubscriptiontypeAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            SubscriptiontypeAttribute attached = SubscriptiontypeAttribute.findSubscriptiontypeAttribute(this.id);
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
    public SubscriptiontypeAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SubscriptiontypeAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
