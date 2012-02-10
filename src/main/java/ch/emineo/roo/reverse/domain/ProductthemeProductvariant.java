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
@Table(name = "producttheme_productvariant")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemeProductvariantPK.class, versionField = "", table = "producttheme_productvariant")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemeProductvariant {

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", referencedColumnName = "PRODUCTTHEMEID", nullable = false, insertable = false, updatable = false)
    private Producttheme productthemeProductthemeid;

	@ManyToOne
    @JoinColumn(name = "VARIANTS_PRODUCTVARIANTID", referencedColumnName = "PRODUCTVARIANTID", nullable = false)
    private Productvariant variantsProductvariantid;

	public Producttheme getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }

	public void setProductthemeProductthemeid(Producttheme productthemeProductthemeid) {
        this.productthemeProductthemeid = productthemeProductthemeid;
    }

	public Productvariant getVariantsProductvariantid() {
        return variantsProductvariantid;
    }

	public void setVariantsProductvariantid(Productvariant variantsProductvariantid) {
        this.variantsProductvariantid = variantsProductvariantid;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemeProductvariant().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemeProductvariants() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemeProductvariant o", Long.class).getSingleResult();
    }

	public static List<ProductthemeProductvariant> findAllProductthemeProductvariants() {
        return entityManager().createQuery("SELECT o FROM ProductthemeProductvariant o", ProductthemeProductvariant.class).getResultList();
    }

	public static ProductthemeProductvariant findProductthemeProductvariant(ProductthemeProductvariantPK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemeProductvariant.class, id);
    }

	public static List<ProductthemeProductvariant> findProductthemeProductvariantEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemeProductvariant o", ProductthemeProductvariant.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemeProductvariant attached = ProductthemeProductvariant.findProductthemeProductvariant(this.id);
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
    public ProductthemeProductvariant merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemeProductvariant merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@EmbeddedId
    private ProductthemeProductvariantPK id;

	public ProductthemeProductvariantPK getId() {
        return this.id;
    }

	public void setId(ProductthemeProductvariantPK id) {
        this.id = id;
    }
}
