package ch.emineo.roo.reverse.domain;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "productsubcategory")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productsubcategory")
@RooDbManaged(automaticallyDelete = true)
public class Productsubcategory {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productsubcategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductsubcategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productsubcategory o", Long.class).getSingleResult();
    }

	public static List<Productsubcategory> findAllProductsubcategorys() {
        return entityManager().createQuery("SELECT o FROM Productsubcategory o", Productsubcategory.class).getResultList();
    }

	public static Productsubcategory findProductsubcategory(Integer productsubcategoryid) {
        if (productsubcategoryid == null) return null;
        return entityManager().find(Productsubcategory.class, productsubcategoryid);
    }

	public static List<Productsubcategory> findProductsubcategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productsubcategory o", Productsubcategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productsubcategory attached = Productsubcategory.findProductsubcategory(this.productsubcategoryid);
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
    public Productsubcategory merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productsubcategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@OneToMany(mappedBy = "subcategoriesProductsubcategoryid")
    private Set<ProductcategoryProductsubcategory> productcategoryProductsubcategories;

	@OneToMany(mappedBy = "productsubcategoryProductsubcategoryid")
    private Set<ProductsubcategoryAttribute> productsubcategoryAttributes;

	@OneToMany(mappedBy = "productsubcategoryProductsubcategoryid")
    private Set<ProductsubcategoryProduct> productsubcategoryProducts;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PICTUREPATH", length = 255)
    private String picturepath;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<ProductcategoryProductsubcategory> getProductcategoryProductsubcategories() {
        return productcategoryProductsubcategories;
    }

	public void setProductcategoryProductsubcategories(Set<ProductcategoryProductsubcategory> productcategoryProductsubcategories) {
        this.productcategoryProductsubcategories = productcategoryProductsubcategories;
    }

	public Set<ProductsubcategoryAttribute> getProductsubcategoryAttributes() {
        return productsubcategoryAttributes;
    }

	public void setProductsubcategoryAttributes(Set<ProductsubcategoryAttribute> productsubcategoryAttributes) {
        this.productsubcategoryAttributes = productsubcategoryAttributes;
    }

	public Set<ProductsubcategoryProduct> getProductsubcategoryProducts() {
        return productsubcategoryProducts;
    }

	public void setProductsubcategoryProducts(Set<ProductsubcategoryProduct> productsubcategoryProducts) {
        this.productsubcategoryProducts = productsubcategoryProducts;
    }

	public boolean isOnline() {
        return online;
    }

	public void setOnline(boolean online) {
        this.online = online;
    }

	public String getPicturepath() {
        return picturepath;
    }

	public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

	public boolean isPublic1() {
        return public1;
    }

	public void setPublic1(boolean public1) {
        this.public1 = public1;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTSUBCATEGORYID")
    private Integer productsubcategoryid;

	public Integer getProductsubcategoryid() {
        return this.productsubcategoryid;
    }

	public void setProductsubcategoryid(Integer id) {
        this.productsubcategoryid = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
