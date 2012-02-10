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
@Table(name = "productsubcategory_product")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductsubcategoryProductPK.class, versionField = "", table = "productsubcategory_product")
@RooDbManaged(automaticallyDelete = true)
public class ProductsubcategoryProduct {

	@EmbeddedId
    private ProductsubcategoryProductPK id;

	public ProductsubcategoryProductPK getId() {
        return this.id;
    }

	public void setId(ProductsubcategoryProductPK id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTS_PRODUCTID", referencedColumnName = "PRODUCTID", nullable = false)
    private Product productsProductid;

	@ManyToOne
    @JoinColumn(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID", referencedColumnName = "PRODUCTSUBCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productsubcategory productsubcategoryProductsubcategoryid;

	public Product getProductsProductid() {
        return productsProductid;
    }

	public void setProductsProductid(Product productsProductid) {
        this.productsProductid = productsProductid;
    }

	public Productsubcategory getProductsubcategoryProductsubcategoryid() {
        return productsubcategoryProductsubcategoryid;
    }

	public void setProductsubcategoryProductsubcategoryid(Productsubcategory productsubcategoryProductsubcategoryid) {
        this.productsubcategoryProductsubcategoryid = productsubcategoryProductsubcategoryid;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductsubcategoryProduct().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductsubcategoryProducts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductsubcategoryProduct o", Long.class).getSingleResult();
    }

	public static List<ProductsubcategoryProduct> findAllProductsubcategoryProducts() {
        return entityManager().createQuery("SELECT o FROM ProductsubcategoryProduct o", ProductsubcategoryProduct.class).getResultList();
    }

	public static ProductsubcategoryProduct findProductsubcategoryProduct(ProductsubcategoryProductPK id) {
        if (id == null) return null;
        return entityManager().find(ProductsubcategoryProduct.class, id);
    }

	public static List<ProductsubcategoryProduct> findProductsubcategoryProductEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductsubcategoryProduct o", ProductsubcategoryProduct.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductsubcategoryProduct attached = ProductsubcategoryProduct.findProductsubcategoryProduct(this.id);
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
    public ProductsubcategoryProduct merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductsubcategoryProduct merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
