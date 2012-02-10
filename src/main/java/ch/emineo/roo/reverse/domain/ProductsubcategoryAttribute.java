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
@Table(name = "productsubcategory_attribute")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductsubcategoryAttributePK.class, versionField = "", table = "productsubcategory_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductsubcategoryAttribute {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductsubcategoryAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductsubcategoryAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductsubcategoryAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductsubcategoryAttribute> findAllProductsubcategoryAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductsubcategoryAttribute o", ProductsubcategoryAttribute.class).getResultList();
    }

	public static ProductsubcategoryAttribute findProductsubcategoryAttribute(ProductsubcategoryAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductsubcategoryAttribute.class, id);
    }

	public static List<ProductsubcategoryAttribute> findProductsubcategoryAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductsubcategoryAttribute o", ProductsubcategoryAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductsubcategoryAttribute attached = ProductsubcategoryAttribute.findProductsubcategoryAttribute(this.id);
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
    public ProductsubcategoryAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductsubcategoryAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@EmbeddedId
    private ProductsubcategoryAttributePK id;

	public ProductsubcategoryAttributePK getId() {
        return this.id;
    }

	public void setId(ProductsubcategoryAttributePK id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID", referencedColumnName = "PRODUCTSUBCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productsubcategory productsubcategoryProductsubcategoryid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Productsubcategory getProductsubcategoryProductsubcategoryid() {
        return productsubcategoryProductsubcategoryid;
    }

	public void setProductsubcategoryProductsubcategoryid(Productsubcategory productsubcategoryProductsubcategoryid) {
        this.productsubcategoryProductsubcategoryid = productsubcategoryProductsubcategoryid;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
