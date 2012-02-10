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
@Table(name = "producttheme_productthemecategory")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemeProductthemecategoryPK.class, versionField = "", table = "producttheme_productthemecategory")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemeProductthemecategory {

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", referencedColumnName = "PRODUCTTHEMEID", nullable = false, insertable = false, updatable = false)
    private Producttheme productthemeProductthemeid;

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMECATEGORIES_PRODUCTTHEMECATEGORYID", referencedColumnName = "PRODUCTTHEMECATEGORYID", nullable = false)
    private Productthemecategory productthemecategoriesProductthemecategoryid;

	public Producttheme getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }

	public void setProductthemeProductthemeid(Producttheme productthemeProductthemeid) {
        this.productthemeProductthemeid = productthemeProductthemeid;
    }

	public Productthemecategory getProductthemecategoriesProductthemecategoryid() {
        return productthemecategoriesProductthemecategoryid;
    }

	public void setProductthemecategoriesProductthemecategoryid(Productthemecategory productthemecategoriesProductthemecategoryid) {
        this.productthemecategoriesProductthemecategoryid = productthemecategoriesProductthemecategoryid;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@EmbeddedId
    private ProductthemeProductthemecategoryPK id;

	public ProductthemeProductthemecategoryPK getId() {
        return this.id;
    }

	public void setId(ProductthemeProductthemecategoryPK id) {
        this.id = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemeProductthemecategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemeProductthemecategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemeProductthemecategory o", Long.class).getSingleResult();
    }

	public static List<ProductthemeProductthemecategory> findAllProductthemeProductthemecategorys() {
        return entityManager().createQuery("SELECT o FROM ProductthemeProductthemecategory o", ProductthemeProductthemecategory.class).getResultList();
    }

	public static ProductthemeProductthemecategory findProductthemeProductthemecategory(ProductthemeProductthemecategoryPK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemeProductthemecategory.class, id);
    }

	public static List<ProductthemeProductthemecategory> findProductthemeProductthemecategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemeProductthemecategory o", ProductthemeProductthemecategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemeProductthemecategory attached = ProductthemeProductthemecategory.findProductthemeProductthemecategory(this.id);
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
    public ProductthemeProductthemecategory merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemeProductthemecategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
