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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "producttheme")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "producttheme")
@RooDbManaged(automaticallyDelete = true)
public class Producttheme {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTTHEMEID")
    private Integer productthemeid;

	public Integer getProductthemeid() {
        return this.productthemeid;
    }

	public void setProductthemeid(Integer id) {
        this.productthemeid = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Producttheme().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Producttheme o", Long.class).getSingleResult();
    }

	public static List<Producttheme> findAllProductthemes() {
        return entityManager().createQuery("SELECT o FROM Producttheme o", Producttheme.class).getResultList();
    }

	public static Producttheme findProducttheme(Integer productthemeid) {
        if (productthemeid == null) return null;
        return entityManager().find(Producttheme.class, productthemeid);
    }

	public static List<Producttheme> findProductthemeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Producttheme o", Producttheme.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Producttheme attached = Producttheme.findProducttheme(this.productthemeid);
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
    public Producttheme merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Producttheme merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@ManyToMany
    @JoinTable(name = "producttheme_productthemesapinfo", joinColumns = { @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "PRODUCTTHEMESAPINFOS_PRODUCTTHEMESAPINFOID", nullable = false) })
    private Set<Productthemesapinfo> productthemesapinfoes;

	@OneToMany(mappedBy = "productthemeProductthemeid")
    private Set<ProductthemeAttribute> productthemeAttributes;

	@OneToMany(mappedBy = "productthemeProductthemeid")
    private Set<ProductthemeProductthemecategory> productthemeProductthemecategories;

	@OneToMany(mappedBy = "productthemeProductthemeid")
    private Set<ProductthemeProductvariant> productthemeProductvariants;

	@OneToMany(mappedBy = "productthemeProductthemeid")
    private Set<Promotion> promotions;

	@OneToMany(mappedBy = "productthemeProductthemeid")
    private Set<Purchaseditem> purchaseditems;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PICTUREPATH", length = 255)
    private String picturepath;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<Productthemesapinfo> getProductthemesapinfoes() {
        return productthemesapinfoes;
    }

	public void setProductthemesapinfoes(Set<Productthemesapinfo> productthemesapinfoes) {
        this.productthemesapinfoes = productthemesapinfoes;
    }

	public Set<ProductthemeAttribute> getProductthemeAttributes() {
        return productthemeAttributes;
    }

	public void setProductthemeAttributes(Set<ProductthemeAttribute> productthemeAttributes) {
        this.productthemeAttributes = productthemeAttributes;
    }

	public Set<ProductthemeProductthemecategory> getProductthemeProductthemecategories() {
        return productthemeProductthemecategories;
    }

	public void setProductthemeProductthemecategories(Set<ProductthemeProductthemecategory> productthemeProductthemecategories) {
        this.productthemeProductthemecategories = productthemeProductthemecategories;
    }

	public Set<ProductthemeProductvariant> getProductthemeProductvariants() {
        return productthemeProductvariants;
    }

	public void setProductthemeProductvariants(Set<ProductthemeProductvariant> productthemeProductvariants) {
        this.productthemeProductvariants = productthemeProductvariants;
    }

	public Set<Promotion> getPromotions() {
        return promotions;
    }

	public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

	public Set<Purchaseditem> getPurchaseditems() {
        return purchaseditems;
    }

	public void setPurchaseditems(Set<Purchaseditem> purchaseditems) {
        this.purchaseditems = purchaseditems;
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
}
