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

@Configurable
@Entity
@Table(name = "productcategory")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productcategory")
@RooDbManaged(automaticallyDelete = true)
public class Productcategory {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productcategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductcategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productcategory o", Long.class).getSingleResult();
    }

	public static List<Productcategory> findAllProductcategorys() {
        return entityManager().createQuery("SELECT o FROM Productcategory o", Productcategory.class).getResultList();
    }

	public static Productcategory findProductcategory(Integer productcategoryid) {
        if (productcategoryid == null) return null;
        return entityManager().find(Productcategory.class, productcategoryid);
    }

	public static List<Productcategory> findProductcategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productcategory o", Productcategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productcategory attached = Productcategory.findProductcategory(this.productcategoryid);
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
    public Productcategory merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productcategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@OneToMany(mappedBy = "productcategoryProductcategoryid")
    private Set<ProductcategoryAttribute> productcategoryAttributes;

	@OneToMany(mappedBy = "productcategoryProductcategoryid")
    private Set<ProductcategoryProductsubcategory> productcategoryProductsubcategories;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PICTUREPATH", length = 255)
    private String picturepath;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<ProductcategoryAttribute> getProductcategoryAttributes() {
        return productcategoryAttributes;
    }

	public void setProductcategoryAttributes(Set<ProductcategoryAttribute> productcategoryAttributes) {
        this.productcategoryAttributes = productcategoryAttributes;
    }

	public Set<ProductcategoryProductsubcategory> getProductcategoryProductsubcategories() {
        return productcategoryProductsubcategories;
    }

	public void setProductcategoryProductsubcategories(Set<ProductcategoryProductsubcategory> productcategoryProductsubcategories) {
        this.productcategoryProductsubcategories = productcategoryProductsubcategories;
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
    @Column(name = "PRODUCTCATEGORYID")
    private Integer productcategoryid;

	public Integer getProductcategoryid() {
        return this.productcategoryid;
    }

	public void setProductcategoryid(Integer id) {
        this.productcategoryid = id;
    }
}
