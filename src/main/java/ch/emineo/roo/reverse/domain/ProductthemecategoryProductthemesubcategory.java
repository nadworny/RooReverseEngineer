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
@Table(name = "productthemecategory_productthemesubcategory")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemecategoryProductthemesubcategoryPK.class, versionField = "", table = "productthemecategory_productthemesubcategory")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemecategoryProductthemesubcategory {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMESUBCATEGORIES_PRODUCTTHEMESUBCATEGORYID", referencedColumnName = "PRODUCTTHEMESUBCATEGORYID", nullable = false)
    private Productthemesubcategory productthemesubcategoriesProductthemesubcategoryid;

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMECATEGORY_PRODUCTTHEMECATEGORYID", referencedColumnName = "PRODUCTTHEMECATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productthemecategory productthemecategoryProductthemecategoryid;

	public Productthemesubcategory getProductthemesubcategoriesProductthemesubcategoryid() {
        return productthemesubcategoriesProductthemesubcategoryid;
    }

	public void setProductthemesubcategoriesProductthemesubcategoryid(Productthemesubcategory productthemesubcategoriesProductthemesubcategoryid) {
        this.productthemesubcategoriesProductthemesubcategoryid = productthemesubcategoriesProductthemesubcategoryid;
    }

	public Productthemecategory getProductthemecategoryProductthemecategoryid() {
        return productthemecategoryProductthemecategoryid;
    }

	public void setProductthemecategoryProductthemecategoryid(Productthemecategory productthemecategoryProductthemecategoryid) {
        this.productthemecategoryProductthemecategoryid = productthemecategoryProductthemecategoryid;
    }

	@EmbeddedId
    private ProductthemecategoryProductthemesubcategoryPK id;

	public ProductthemecategoryProductthemesubcategoryPK getId() {
        return this.id;
    }

	public void setId(ProductthemecategoryProductthemesubcategoryPK id) {
        this.id = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemecategoryProductthemesubcategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemecategoryProductthemesubcategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemecategoryProductthemesubcategory o", Long.class).getSingleResult();
    }

	public static List<ProductthemecategoryProductthemesubcategory> findAllProductthemecategoryProductthemesubcategorys() {
        return entityManager().createQuery("SELECT o FROM ProductthemecategoryProductthemesubcategory o", ProductthemecategoryProductthemesubcategory.class).getResultList();
    }

	public static ProductthemecategoryProductthemesubcategory findProductthemecategoryProductthemesubcategory(ProductthemecategoryProductthemesubcategoryPK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemecategoryProductthemesubcategory.class, id);
    }

	public static List<ProductthemecategoryProductthemesubcategory> findProductthemecategoryProductthemesubcategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemecategoryProductthemesubcategory o", ProductthemecategoryProductthemesubcategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemecategoryProductthemesubcategory attached = ProductthemecategoryProductthemesubcategory.findProductthemecategoryProductthemesubcategory(this.id);
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
    public ProductthemecategoryProductthemesubcategory merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemecategoryProductthemesubcategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
