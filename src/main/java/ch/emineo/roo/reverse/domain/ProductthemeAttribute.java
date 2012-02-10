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

@Entity
@Table(name = "producttheme_attribute")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemeAttributePK.class, versionField = "", table = "producttheme_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemeAttribute {

	@EmbeddedId
    private ProductthemeAttributePK id;

	public ProductthemeAttributePK getId() {
        return this.id;
    }

	public void setId(ProductthemeAttributePK id) {
        this.id = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemeAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemeAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemeAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductthemeAttribute> findAllProductthemeAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductthemeAttribute o", ProductthemeAttribute.class).getResultList();
    }

	public static ProductthemeAttribute findProductthemeAttribute(ProductthemeAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemeAttribute.class, id);
    }

	public static List<ProductthemeAttribute> findProductthemeAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemeAttribute o", ProductthemeAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemeAttribute attached = ProductthemeAttribute.findProductthemeAttribute(this.id);
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
    public ProductthemeAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemeAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", referencedColumnName = "PRODUCTTHEMEID", nullable = false, insertable = false, updatable = false)
    private Producttheme productthemeProductthemeid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Producttheme getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }

	public void setProductthemeProductthemeid(Producttheme productthemeProductthemeid) {
        this.productthemeProductthemeid = productthemeProductthemeid;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }
}
