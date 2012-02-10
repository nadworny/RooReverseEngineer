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
@Table(name = "productthemesubcategory")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productthemesubcategory")
@RooDbManaged(automaticallyDelete = true)
public class Productthemesubcategory {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@OneToMany(mappedBy = "productthemesubcategoriesProductthemesubcategoryid")
    private Set<ProductthemecategoryProductthemesubcategory> productthemecategoryProductthemesubcategories;

	@OneToMany(mappedBy = "productthemesubcategoryProductthemesubcategoryid")
    private Set<ProductthemesubcategoryAttribute> productthemesubcategoryAttributes;

	@OneToMany(mappedBy = "productthemesubcategoryProductthemesubcategoryid")
    private Set<ProductthemesubcategoryProductthemecontentholder> productthemesubcategoryProductthemecontentholders;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<ProductthemecategoryProductthemesubcategory> getProductthemecategoryProductthemesubcategories() {
        return productthemecategoryProductthemesubcategories;
    }

	public void setProductthemecategoryProductthemesubcategories(Set<ProductthemecategoryProductthemesubcategory> productthemecategoryProductthemesubcategories) {
        this.productthemecategoryProductthemesubcategories = productthemecategoryProductthemesubcategories;
    }

	public Set<ProductthemesubcategoryAttribute> getProductthemesubcategoryAttributes() {
        return productthemesubcategoryAttributes;
    }

	public void setProductthemesubcategoryAttributes(Set<ProductthemesubcategoryAttribute> productthemesubcategoryAttributes) {
        this.productthemesubcategoryAttributes = productthemesubcategoryAttributes;
    }

	public Set<ProductthemesubcategoryProductthemecontentholder> getProductthemesubcategoryProductthemecontentholders() {
        return productthemesubcategoryProductthemecontentholders;
    }

	public void setProductthemesubcategoryProductthemecontentholders(Set<ProductthemesubcategoryProductthemecontentholder> productthemesubcategoryProductthemecontentholders) {
        this.productthemesubcategoryProductthemecontentholders = productthemesubcategoryProductthemecontentholders;
    }

	public boolean isOnline() {
        return online;
    }

	public void setOnline(boolean online) {
        this.online = online;
    }

	public boolean isPublic1() {
        return public1;
    }

	public void setPublic1(boolean public1) {
        this.public1 = public1;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTTHEMESUBCATEGORYID")
    private Integer productthemesubcategoryid;

	public Integer getProductthemesubcategoryid() {
        return this.productthemesubcategoryid;
    }

	public void setProductthemesubcategoryid(Integer id) {
        this.productthemesubcategoryid = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productthemesubcategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemesubcategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productthemesubcategory o", Long.class).getSingleResult();
    }

	public static List<Productthemesubcategory> findAllProductthemesubcategorys() {
        return entityManager().createQuery("SELECT o FROM Productthemesubcategory o", Productthemesubcategory.class).getResultList();
    }

	public static Productthemesubcategory findProductthemesubcategory(Integer productthemesubcategoryid) {
        if (productthemesubcategoryid == null) return null;
        return entityManager().find(Productthemesubcategory.class, productthemesubcategoryid);
    }

	public static List<Productthemesubcategory> findProductthemesubcategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productthemesubcategory o", Productthemesubcategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productthemesubcategory attached = Productthemesubcategory.findProductthemesubcategory(this.productthemesubcategoryid);
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
    public Productthemesubcategory merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productthemesubcategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
