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
@Table(name = "product_productvariant")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductProductvariantPK.class, versionField = "", table = "product_productvariant")
@RooDbManaged(automaticallyDelete = true)
public class ProductProductvariant {

	@ManyToOne
    @JoinColumn(name = "PRODUCT_PRODUCTID", referencedColumnName = "PRODUCTID", nullable = false, insertable = false, updatable = false)
    private Product productProductid;

	@ManyToOne
    @JoinColumn(name = "VARIANTS_PRODUCTVARIANTID", referencedColumnName = "PRODUCTVARIANTID", nullable = false)
    private Productvariant variantsProductvariantid;

	public Product getProductProductid() {
        return productProductid;
    }

	public void setProductProductid(Product productProductid) {
        this.productProductid = productProductid;
    }

	public Productvariant getVariantsProductvariantid() {
        return variantsProductvariantid;
    }

	public void setVariantsProductvariantid(Productvariant variantsProductvariantid) {
        this.variantsProductvariantid = variantsProductvariantid;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductProductvariant().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductProductvariants() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductProductvariant o", Long.class).getSingleResult();
    }

	public static List<ProductProductvariant> findAllProductProductvariants() {
        return entityManager().createQuery("SELECT o FROM ProductProductvariant o", ProductProductvariant.class).getResultList();
    }

	public static ProductProductvariant findProductProductvariant(ProductProductvariantPK id) {
        if (id == null) return null;
        return entityManager().find(ProductProductvariant.class, id);
    }

	public static List<ProductProductvariant> findProductProductvariantEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductProductvariant o", ProductProductvariant.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductProductvariant attached = ProductProductvariant.findProductProductvariant(this.id);
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
    public ProductProductvariant merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductProductvariant merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@EmbeddedId
    private ProductProductvariantPK id;

	public ProductProductvariantPK getId() {
        return this.id;
    }

	public void setId(ProductProductvariantPK id) {
        this.id = id;
    }
}
