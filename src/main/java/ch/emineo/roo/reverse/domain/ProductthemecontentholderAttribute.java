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
@Table(name = "productthemecontentholder_attribute")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemecontentholderAttributePK.class, versionField = "", table = "productthemecontentholder_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemecontentholderAttribute {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMECONTENTHOLDER_PRODUCTTHEMECONTENTHOLDERID", referencedColumnName = "PRODUCTTHEMECONTENTHOLDERID", nullable = false, insertable = false, updatable = false)
    private Productthemecontentholder productthemecontentholderProductthemecontentholderid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Productthemecontentholder getProductthemecontentholderProductthemecontentholderid() {
        return productthemecontentholderProductthemecontentholderid;
    }

	public void setProductthemecontentholderProductthemecontentholderid(Productthemecontentholder productthemecontentholderProductthemecontentholderid) {
        this.productthemecontentholderProductthemecontentholderid = productthemecontentholderProductthemecontentholderid;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	@EmbeddedId
    private ProductthemecontentholderAttributePK id;

	public ProductthemecontentholderAttributePK getId() {
        return this.id;
    }

	public void setId(ProductthemecontentholderAttributePK id) {
        this.id = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemecontentholderAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemecontentholderAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemecontentholderAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductthemecontentholderAttribute> findAllProductthemecontentholderAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductthemecontentholderAttribute o", ProductthemecontentholderAttribute.class).getResultList();
    }

	public static ProductthemecontentholderAttribute findProductthemecontentholderAttribute(ProductthemecontentholderAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemecontentholderAttribute.class, id);
    }

	public static List<ProductthemecontentholderAttribute> findProductthemecontentholderAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemecontentholderAttribute o", ProductthemecontentholderAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemecontentholderAttribute attached = ProductthemecontentholderAttribute.findProductthemecontentholderAttribute(this.id);
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
    public ProductthemecontentholderAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemecontentholderAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
