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
@Table(name = "productthemecategory_attribute")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemecategoryAttributePK.class, versionField = "", table = "productthemecategory_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemecategoryAttribute {

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMECATEGORY_PRODUCTTHEMECATEGORYID", referencedColumnName = "PRODUCTTHEMECATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productthemecategory productthemecategoryProductthemecategoryid;

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	public Productthemecategory getProductthemecategoryProductthemecategoryid() {
        return productthemecategoryProductthemecategoryid;
    }

	public void setProductthemecategoryProductthemecategoryid(Productthemecategory productthemecategoryProductthemecategoryid) {
        this.productthemecategoryProductthemecategoryid = productthemecategoryProductthemecategoryid;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemecategoryAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemecategoryAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemecategoryAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductthemecategoryAttribute> findAllProductthemecategoryAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductthemecategoryAttribute o", ProductthemecategoryAttribute.class).getResultList();
    }

	public static ProductthemecategoryAttribute findProductthemecategoryAttribute(ProductthemecategoryAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemecategoryAttribute.class, id);
    }

	public static List<ProductthemecategoryAttribute> findProductthemecategoryAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemecategoryAttribute o", ProductthemecategoryAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemecategoryAttribute attached = ProductthemecategoryAttribute.findProductthemecategoryAttribute(this.id);
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
    public ProductthemecategoryAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemecategoryAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@EmbeddedId
    private ProductthemecategoryAttributePK id;

	public ProductthemecategoryAttributePK getId() {
        return this.id;
    }

	public void setId(ProductthemecategoryAttributePK id) {
        this.id = id;
    }
}
