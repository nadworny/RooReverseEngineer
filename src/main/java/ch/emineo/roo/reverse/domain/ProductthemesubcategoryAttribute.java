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
@Table(name = "productthemesubcategory_attribute")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemesubcategoryAttributePK.class, versionField = "", table = "productthemesubcategory_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemesubcategoryAttribute {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMESUBCATEGORY_PRODUCTTHEMESUBCATEGORYID", referencedColumnName = "PRODUCTTHEMESUBCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productthemesubcategory productthemesubcategoryProductthemesubcategoryid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Productthemesubcategory getProductthemesubcategoryProductthemesubcategoryid() {
        return productthemesubcategoryProductthemesubcategoryid;
    }

	public void setProductthemesubcategoryProductthemesubcategoryid(Productthemesubcategory productthemesubcategoryProductthemesubcategoryid) {
        this.productthemesubcategoryProductthemesubcategoryid = productthemesubcategoryProductthemesubcategoryid;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	@EmbeddedId
    private ProductthemesubcategoryAttributePK id;

	public ProductthemesubcategoryAttributePK getId() {
        return this.id;
    }

	public void setId(ProductthemesubcategoryAttributePK id) {
        this.id = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemesubcategoryAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemesubcategoryAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemesubcategoryAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductthemesubcategoryAttribute> findAllProductthemesubcategoryAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductthemesubcategoryAttribute o", ProductthemesubcategoryAttribute.class).getResultList();
    }

	public static ProductthemesubcategoryAttribute findProductthemesubcategoryAttribute(ProductthemesubcategoryAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemesubcategoryAttribute.class, id);
    }

	public static List<ProductthemesubcategoryAttribute> findProductthemesubcategoryAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemesubcategoryAttribute o", ProductthemesubcategoryAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemesubcategoryAttribute attached = ProductthemesubcategoryAttribute.findProductthemesubcategoryAttribute(this.id);
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
    public ProductthemesubcategoryAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemesubcategoryAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
