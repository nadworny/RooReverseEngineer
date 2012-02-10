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
@Table(name = "productthemecategory")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productthemecategory")
@RooDbManaged(automaticallyDelete = true)
public class Productthemecategory {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productthemecategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemecategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productthemecategory o", Long.class).getSingleResult();
    }

	public static List<Productthemecategory> findAllProductthemecategorys() {
        return entityManager().createQuery("SELECT o FROM Productthemecategory o", Productthemecategory.class).getResultList();
    }

	public static Productthemecategory findProductthemecategory(Integer productthemecategoryid) {
        if (productthemecategoryid == null) return null;
        return entityManager().find(Productthemecategory.class, productthemecategoryid);
    }

	public static List<Productthemecategory> findProductthemecategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productthemecategory o", Productthemecategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productthemecategory attached = Productthemecategory.findProductthemecategory(this.productthemecategoryid);
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
    public Productthemecategory merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productthemecategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@OneToMany(mappedBy = "productthemecategoriesProductthemecategoryid")
    private Set<ProductthemeProductthemecategory> productthemeProductthemecategories;

	@OneToMany(mappedBy = "productthemecategoryProductthemecategoryid")
    private Set<ProductthemecategoryAttribute> productthemecategoryAttributes;

	@OneToMany(mappedBy = "productthemecategoryProductthemecategoryid")
    private Set<ProductthemecategoryProductthemesubcategory> productthemecategoryProductthemesubcategories;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<ProductthemeProductthemecategory> getProductthemeProductthemecategories() {
        return productthemeProductthemecategories;
    }

	public void setProductthemeProductthemecategories(Set<ProductthemeProductthemecategory> productthemeProductthemecategories) {
        this.productthemeProductthemecategories = productthemeProductthemecategories;
    }

	public Set<ProductthemecategoryAttribute> getProductthemecategoryAttributes() {
        return productthemecategoryAttributes;
    }

	public void setProductthemecategoryAttributes(Set<ProductthemecategoryAttribute> productthemecategoryAttributes) {
        this.productthemecategoryAttributes = productthemecategoryAttributes;
    }

	public Set<ProductthemecategoryProductthemesubcategory> getProductthemecategoryProductthemesubcategories() {
        return productthemecategoryProductthemesubcategories;
    }

	public void setProductthemecategoryProductthemesubcategories(Set<ProductthemecategoryProductthemesubcategory> productthemecategoryProductthemesubcategories) {
        this.productthemecategoryProductthemesubcategories = productthemecategoryProductthemesubcategories;
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
    @Column(name = "PRODUCTTHEMECATEGORYID")
    private Integer productthemecategoryid;

	public Integer getProductthemecategoryid() {
        return this.productthemecategoryid;
    }

	public void setProductthemecategoryid(Integer id) {
        this.productthemecategoryid = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
