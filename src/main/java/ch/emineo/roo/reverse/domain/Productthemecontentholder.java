package ch.emineo.roo.reverse.domain;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "productthemecontentholder")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productthemecontentholder")
@RooDbManaged(automaticallyDelete = true)
public class Productthemecontentholder {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTTHEMECONTENTHOLDERID")
    private Integer productthemecontentholderid;

	public Integer getProductthemecontentholderid() {
        return this.productthemecontentholderid;
    }

	public void setProductthemecontentholderid(Integer id) {
        this.productthemecontentholderid = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@OneToMany(mappedBy = "productthemecontentholderProductthemecontentholderid")
    private Set<ProductthemecontentholderAttribute> productthemecontentholderAttributes;

	@OneToMany(mappedBy = "productthemecontentholdersProductthemecontentholderid")
    private Set<ProductthemesubcategoryProductthemecontentholder> productthemesubcategoryProductthemecontentholders;

	@ManyToOne
    @JoinColumn(name = "PRODUCTBUILD_FK", referencedColumnName = "PRODUCTBUILDID")
    private Productbuild productbuildFk;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<ProductthemecontentholderAttribute> getProductthemecontentholderAttributes() {
        return productthemecontentholderAttributes;
    }

	public void setProductthemecontentholderAttributes(Set<ProductthemecontentholderAttribute> productthemecontentholderAttributes) {
        this.productthemecontentholderAttributes = productthemecontentholderAttributes;
    }

	public Set<ProductthemesubcategoryProductthemecontentholder> getProductthemesubcategoryProductthemecontentholders() {
        return productthemesubcategoryProductthemecontentholders;
    }

	public void setProductthemesubcategoryProductthemecontentholders(Set<ProductthemesubcategoryProductthemecontentholder> productthemesubcategoryProductthemecontentholders) {
        this.productthemesubcategoryProductthemecontentholders = productthemesubcategoryProductthemecontentholders;
    }

	public Productbuild getProductbuildFk() {
        return productbuildFk;
    }

	public void setProductbuildFk(Productbuild productbuildFk) {
        this.productbuildFk = productbuildFk;
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

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productthemecontentholder().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemecontentholders() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productthemecontentholder o", Long.class).getSingleResult();
    }

	public static List<Productthemecontentholder> findAllProductthemecontentholders() {
        return entityManager().createQuery("SELECT o FROM Productthemecontentholder o", Productthemecontentholder.class).getResultList();
    }

	public static Productthemecontentholder findProductthemecontentholder(Integer productthemecontentholderid) {
        if (productthemecontentholderid == null) return null;
        return entityManager().find(Productthemecontentholder.class, productthemecontentholderid);
    }

	public static List<Productthemecontentholder> findProductthemecontentholderEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productthemecontentholder o", Productthemecontentholder.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productthemecontentholder attached = Productthemecontentholder.findProductthemecontentholder(this.productthemecontentholderid);
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
    public Productthemecontentholder merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productthemecontentholder merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
