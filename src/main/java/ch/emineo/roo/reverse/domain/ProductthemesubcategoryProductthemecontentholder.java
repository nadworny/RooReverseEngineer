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
@Table(name = "productthemesubcategory_productthemecontentholder")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductthemesubcategoryProductthemecontentholderPK.class, versionField = "", table = "productthemesubcategory_productthemecontentholder")
@RooDbManaged(automaticallyDelete = true)
public class ProductthemesubcategoryProductthemecontentholder {

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMESUBCATEGORY_PRODUCTTHEMESUBCATEGORYID", referencedColumnName = "PRODUCTTHEMESUBCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productthemesubcategory productthemesubcategoryProductthemesubcategoryid;

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEMECONTENTHOLDERS_PRODUCTTHEMECONTENTHOLDERID", referencedColumnName = "PRODUCTTHEMECONTENTHOLDERID", nullable = false)
    private Productthemecontentholder productthemecontentholdersProductthemecontentholderid;

	public Productthemesubcategory getProductthemesubcategoryProductthemesubcategoryid() {
        return productthemesubcategoryProductthemesubcategoryid;
    }

	public void setProductthemesubcategoryProductthemesubcategoryid(Productthemesubcategory productthemesubcategoryProductthemesubcategoryid) {
        this.productthemesubcategoryProductthemesubcategoryid = productthemesubcategoryProductthemesubcategoryid;
    }

	public Productthemecontentholder getProductthemecontentholdersProductthemecontentholderid() {
        return productthemecontentholdersProductthemecontentholderid;
    }

	public void setProductthemecontentholdersProductthemecontentholderid(Productthemecontentholder productthemecontentholdersProductthemecontentholderid) {
        this.productthemecontentholdersProductthemecontentholderid = productthemecontentholdersProductthemecontentholderid;
    }

	@EmbeddedId
    private ProductthemesubcategoryProductthemecontentholderPK id;

	public ProductthemesubcategoryProductthemecontentholderPK getId() {
        return this.id;
    }

	public void setId(ProductthemesubcategoryProductthemecontentholderPK id) {
        this.id = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductthemesubcategoryProductthemecontentholder().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemesubcategoryProductthemecontentholders() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductthemesubcategoryProductthemecontentholder o", Long.class).getSingleResult();
    }

	public static List<ProductthemesubcategoryProductthemecontentholder> findAllProductthemesubcategoryProductthemecontentholders() {
        return entityManager().createQuery("SELECT o FROM ProductthemesubcategoryProductthemecontentholder o", ProductthemesubcategoryProductthemecontentholder.class).getResultList();
    }

	public static ProductthemesubcategoryProductthemecontentholder findProductthemesubcategoryProductthemecontentholder(ProductthemesubcategoryProductthemecontentholderPK id) {
        if (id == null) return null;
        return entityManager().find(ProductthemesubcategoryProductthemecontentholder.class, id);
    }

	public static List<ProductthemesubcategoryProductthemecontentholder> findProductthemesubcategoryProductthemecontentholderEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductthemesubcategoryProductthemecontentholder o", ProductthemesubcategoryProductthemecontentholder.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductthemesubcategoryProductthemecontentholder attached = ProductthemesubcategoryProductthemecontentholder.findProductthemesubcategoryProductthemecontentholder(this.id);
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
    public ProductthemesubcategoryProductthemecontentholder merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductthemesubcategoryProductthemecontentholder merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
