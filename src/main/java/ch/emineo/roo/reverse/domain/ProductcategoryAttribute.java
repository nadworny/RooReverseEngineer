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
@Table(name = "productcategory_attribute")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductcategoryAttributePK.class, versionField = "", table = "productcategory_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductcategoryAttribute {

	@ManyToOne
    @JoinColumn(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID", referencedColumnName = "PRODUCTCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productcategory productcategoryProductcategoryid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Productcategory getProductcategoryProductcategoryid() {
        return productcategoryProductcategoryid;
    }

	public void setProductcategoryProductcategoryid(Productcategory productcategoryProductcategoryid) {
        this.productcategoryProductcategoryid = productcategoryProductcategoryid;
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
        EntityManager em = new ProductcategoryAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductcategoryAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductcategoryAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductcategoryAttribute> findAllProductcategoryAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductcategoryAttribute o", ProductcategoryAttribute.class).getResultList();
    }

	public static ProductcategoryAttribute findProductcategoryAttribute(ProductcategoryAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductcategoryAttribute.class, id);
    }

	public static List<ProductcategoryAttribute> findProductcategoryAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductcategoryAttribute o", ProductcategoryAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductcategoryAttribute attached = ProductcategoryAttribute.findProductcategoryAttribute(this.id);
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
    public ProductcategoryAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductcategoryAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@EmbeddedId
    private ProductcategoryAttributePK id;

	public ProductcategoryAttributePK getId() {
        return this.id;
    }

	public void setId(ProductcategoryAttributePK id) {
        this.id = id;
    }
}
