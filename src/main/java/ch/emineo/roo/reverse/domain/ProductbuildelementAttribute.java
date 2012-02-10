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
@Table(name = "productbuildelement_attribute")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductbuildelementAttributePK.class, versionField = "", table = "productbuildelement_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductbuildelementAttribute {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductbuildelementAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductbuildelementAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductbuildelementAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductbuildelementAttribute> findAllProductbuildelementAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductbuildelementAttribute o", ProductbuildelementAttribute.class).getResultList();
    }

	public static ProductbuildelementAttribute findProductbuildelementAttribute(ProductbuildelementAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductbuildelementAttribute.class, id);
    }

	public static List<ProductbuildelementAttribute> findProductbuildelementAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductbuildelementAttribute o", ProductbuildelementAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductbuildelementAttribute attached = ProductbuildelementAttribute.findProductbuildelementAttribute(this.id);
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
    public ProductbuildelementAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductbuildelementAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@EmbeddedId
    private ProductbuildelementAttributePK id;

	public ProductbuildelementAttributePK getId() {
        return this.id;
    }

	public void setId(ProductbuildelementAttributePK id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTBUILDELEMENT_PRODUCTBUILDELEMENTID", referencedColumnName = "PRODUCTBUILDELEMENTID", nullable = false, insertable = false, updatable = false)
    private Productbuildelement productbuildelementProductbuildelementid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Productbuildelement getProductbuildelementProductbuildelementid() {
        return productbuildelementProductbuildelementid;
    }

	public void setProductbuildelementProductbuildelementid(Productbuildelement productbuildelementProductbuildelementid) {
        this.productbuildelementProductbuildelementid = productbuildelementProductbuildelementid;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }
}
