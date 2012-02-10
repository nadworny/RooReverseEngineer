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
@Table(name = "product")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "product")
@RooDbManaged(automaticallyDelete = true)
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTID")
    private Integer productid;

	public Integer getProductid() {
        return this.productid;
    }

	public void setProductid(Integer id) {
        this.productid = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Product().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProducts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Product o", Long.class).getSingleResult();
    }

	public static List<Product> findAllProducts() {
        return entityManager().createQuery("SELECT o FROM Product o", Product.class).getResultList();
    }

	public static Product findProduct(Integer productid) {
        if (productid == null) return null;
        return entityManager().find(Product.class, productid);
    }

	public static List<Product> findProductEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Product o", Product.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Product attached = Product.findProduct(this.productid);
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
    public Product merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Product merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@OneToMany(mappedBy = "productProductid")
    private Set<ProductAttribute> productAttributes;

	@OneToMany(mappedBy = "productProductid")
    private Set<ProductProductvariant> productProductvariants;

	@OneToMany(mappedBy = "productsProductid")
    private Set<ProductsubcategoryProduct> productsubcategoryProducts;

	@OneToMany(mappedBy = "productProductid")
    private Set<Promotion> promotions;

	@OneToMany(mappedBy = "productProductid")
    private Set<Purchaseditem> purchaseditems;

	@ManyToOne
    @JoinColumn(name = "PRODUCTBUILD_FK", referencedColumnName = "PRODUCTBUILDID")
    private Productbuild productbuildFk;

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

	public Set<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

	public void setProductAttributes(Set<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

	public Set<ProductProductvariant> getProductProductvariants() {
        return productProductvariants;
    }

	public void setProductProductvariants(Set<ProductProductvariant> productProductvariants) {
        this.productProductvariants = productProductvariants;
    }

	public Set<ProductsubcategoryProduct> getProductsubcategoryProducts() {
        return productsubcategoryProducts;
    }

	public void setProductsubcategoryProducts(Set<ProductsubcategoryProduct> productsubcategoryProducts) {
        this.productsubcategoryProducts = productsubcategoryProducts;
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
