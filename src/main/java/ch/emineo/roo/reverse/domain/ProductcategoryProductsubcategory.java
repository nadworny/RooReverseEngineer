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
@Table(name = "productcategory_productsubcategory")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductcategoryProductsubcategoryPK.class, versionField = "", table = "productcategory_productsubcategory")
@RooDbManaged(automaticallyDelete = true)
public class ProductcategoryProductsubcategory {

	@EmbeddedId
    private ProductcategoryProductsubcategoryPK id;

	public ProductcategoryProductsubcategoryPK getId() {
        return this.id;
    }

	public void setId(ProductcategoryProductsubcategoryPK id) {
        this.id = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID", referencedColumnName = "PRODUCTCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productcategory productcategoryProductcategoryid;

	@ManyToOne
    @JoinColumn(name = "SUBCATEGORIES_PRODUCTSUBCATEGORYID", referencedColumnName = "PRODUCTSUBCATEGORYID", nullable = false)
    private Productsubcategory subcategoriesProductsubcategoryid;

	public Productcategory getProductcategoryProductcategoryid() {
        return productcategoryProductcategoryid;
    }

	public void setProductcategoryProductcategoryid(Productcategory productcategoryProductcategoryid) {
        this.productcategoryProductcategoryid = productcategoryProductcategoryid;
    }

	public Productsubcategory getSubcategoriesProductsubcategoryid() {
        return subcategoriesProductsubcategoryid;
    }

	public void setSubcategoriesProductsubcategoryid(Productsubcategory subcategoriesProductsubcategoryid) {
        this.subcategoriesProductsubcategoryid = subcategoriesProductsubcategoryid;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductcategoryProductsubcategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductcategoryProductsubcategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductcategoryProductsubcategory o", Long.class).getSingleResult();
    }

	public static List<ProductcategoryProductsubcategory> findAllProductcategoryProductsubcategorys() {
        return entityManager().createQuery("SELECT o FROM ProductcategoryProductsubcategory o", ProductcategoryProductsubcategory.class).getResultList();
    }

	public static ProductcategoryProductsubcategory findProductcategoryProductsubcategory(ProductcategoryProductsubcategoryPK id) {
        if (id == null) return null;
        return entityManager().find(ProductcategoryProductsubcategory.class, id);
    }

	public static List<ProductcategoryProductsubcategory> findProductcategoryProductsubcategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductcategoryProductsubcategory o", ProductcategoryProductsubcategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductcategoryProductsubcategory attached = ProductcategoryProductsubcategory.findProductcategoryProductsubcategory(this.id);
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
    public ProductcategoryProductsubcategory merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductcategoryProductsubcategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
