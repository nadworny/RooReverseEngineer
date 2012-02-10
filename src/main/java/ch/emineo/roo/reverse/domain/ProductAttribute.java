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
@Table(name = "product_attribute")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductAttributePK.class, versionField = "", table = "product_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductAttribute {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductAttribute> findAllProductAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductAttribute o", ProductAttribute.class).getResultList();
    }

	public static ProductAttribute findProductAttribute(ProductAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductAttribute.class, id);
    }

	public static List<ProductAttribute> findProductAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductAttribute o", ProductAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductAttribute attached = ProductAttribute.findProductAttribute(this.id);
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
    public ProductAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	@ManyToOne
    @JoinColumn(name = "PRODUCT_PRODUCTID", referencedColumnName = "PRODUCTID", nullable = false, insertable = false, updatable = false)
    private Product productProductid;

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	public Product getProductProductid() {
        return productProductid;
    }

	public void setProductProductid(Product productProductid) {
        this.productProductid = productProductid;
    }

	@EmbeddedId
    private ProductAttributePK id;

	public ProductAttributePK getId() {
        return this.id;
    }

	public void setId(ProductAttributePK id) {
        this.id = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
