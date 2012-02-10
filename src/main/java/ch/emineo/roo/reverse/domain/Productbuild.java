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
@Table(name = "productbuild")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productbuild")
@RooDbManaged(automaticallyDelete = true)
public class Productbuild {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productbuild().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductbuilds() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productbuild o", Long.class).getSingleResult();
    }

	public static List<Productbuild> findAllProductbuilds() {
        return entityManager().createQuery("SELECT o FROM Productbuild o", Productbuild.class).getResultList();
    }

	public static Productbuild findProductbuild(Integer productbuildid) {
        if (productbuildid == null) return null;
        return entityManager().find(Productbuild.class, productbuildid);
    }

	public static List<Productbuild> findProductbuildEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productbuild o", Productbuild.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productbuild attached = Productbuild.findProductbuild(this.productbuildid);
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
    public Productbuild merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productbuild merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTBUILDID")
    private Integer productbuildid;

	public Integer getProductbuildid() {
        return this.productbuildid;
    }

	public void setProductbuildid(Integer id) {
        this.productbuildid = id;
    }

	@OneToMany(mappedBy = "productbuildFk")
    private Set<Product> products;

	@OneToMany(mappedBy = "productbuildProductbuildid")
    private Set<ProductbuildAttribute> productbuildAttributes;

	@OneToMany(mappedBy = "productbuildProductbuildid")
    private Set<ProductbuildProductbuildelement> productbuildProductbuildelements;

	@OneToMany(mappedBy = "productbuildFk")
    private Set<Productthemecontentholder> productthemecontentholders;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PICTUREPATH", length = 255)
    private String picturepath;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	@Column(name = "SAMPLE")
    @NotNull
    private boolean sample;

	public Set<Product> getProducts() {
        return products;
    }

	public void setProducts(Set<Product> products) {
        this.products = products;
    }

	public Set<ProductbuildAttribute> getProductbuildAttributes() {
        return productbuildAttributes;
    }

	public void setProductbuildAttributes(Set<ProductbuildAttribute> productbuildAttributes) {
        this.productbuildAttributes = productbuildAttributes;
    }

	public Set<ProductbuildProductbuildelement> getProductbuildProductbuildelements() {
        return productbuildProductbuildelements;
    }

	public void setProductbuildProductbuildelements(Set<ProductbuildProductbuildelement> productbuildProductbuildelements) {
        this.productbuildProductbuildelements = productbuildProductbuildelements;
    }

	public Set<Productthemecontentholder> getProductthemecontentholders() {
        return productthemecontentholders;
    }

	public void setProductthemecontentholders(Set<Productthemecontentholder> productthemecontentholders) {
        this.productthemecontentholders = productthemecontentholders;
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

	public boolean isSample() {
        return sample;
    }

	public void setSample(boolean sample) {
        this.sample = sample;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
