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
@Table(name = "productbuild_attribute")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductbuildAttributePK.class, versionField = "", table = "productbuild_attribute")
@RooDbManaged(automaticallyDelete = true)
public class ProductbuildAttribute {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductbuildAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductbuildAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductbuildAttribute o", Long.class).getSingleResult();
    }

	public static List<ProductbuildAttribute> findAllProductbuildAttributes() {
        return entityManager().createQuery("SELECT o FROM ProductbuildAttribute o", ProductbuildAttribute.class).getResultList();
    }

	public static ProductbuildAttribute findProductbuildAttribute(ProductbuildAttributePK id) {
        if (id == null) return null;
        return entityManager().find(ProductbuildAttribute.class, id);
    }

	public static List<ProductbuildAttribute> findProductbuildAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductbuildAttribute o", ProductbuildAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductbuildAttribute attached = ProductbuildAttribute.findProductbuildAttribute(this.id);
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
    public ProductbuildAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductbuildAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTBUILD_PRODUCTBUILDID", referencedColumnName = "PRODUCTBUILDID", nullable = false, insertable = false, updatable = false)
    private Productbuild productbuildProductbuildid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public Productbuild getProductbuildProductbuildid() {
        return productbuildProductbuildid;
    }

	public void setProductbuildProductbuildid(Productbuild productbuildProductbuildid) {
        this.productbuildProductbuildid = productbuildProductbuildid;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	@EmbeddedId
    private ProductbuildAttributePK id;

	public ProductbuildAttributePK getId() {
        return this.id;
    }

	public void setId(ProductbuildAttributePK id) {
        this.id = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
