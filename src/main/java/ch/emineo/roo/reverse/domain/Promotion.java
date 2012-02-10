package ch.emineo.roo.reverse.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@Table(name = "promotion")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "promotion")
@RooDbManaged(automaticallyDelete = true)
public class Promotion {

	@OneToMany(mappedBy = "promotionFk")
    private Set<Promotioncode> promotioncodes;

	@OneToMany(mappedBy = "promotionreferencePromotionid")
    private Set<Purchaseditem> purchaseditems;

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", referencedColumnName = "PRODUCTTHEMEID")
    private Producttheme productthemeProductthemeid;

	@ManyToOne
    @JoinColumn(name = "PRODUCT_PRODUCTID", referencedColumnName = "PRODUCTID")
    private Product productProductid;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PROMOTIONEND")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date promotionend;

	@Column(name = "PROMOTIONNAME", length = 255)
    @NotNull
    private String promotionname;

	@Column(name = "PROMOTIONSTART")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date promotionstart;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<Promotioncode> getPromotioncodes() {
        return promotioncodes;
    }

	public void setPromotioncodes(Set<Promotioncode> promotioncodes) {
        this.promotioncodes = promotioncodes;
    }

	public Set<Purchaseditem> getPurchaseditems() {
        return purchaseditems;
    }

	public void setPurchaseditems(Set<Purchaseditem> purchaseditems) {
        this.purchaseditems = purchaseditems;
    }

	public Producttheme getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }

	public void setProductthemeProductthemeid(Producttheme productthemeProductthemeid) {
        this.productthemeProductthemeid = productthemeProductthemeid;
    }

	public Product getProductProductid() {
        return productProductid;
    }

	public void setProductProductid(Product productProductid) {
        this.productProductid = productProductid;
    }

	public boolean isOnline() {
        return online;
    }

	public void setOnline(boolean online) {
        this.online = online;
    }

	public Date getPromotionend() {
        return promotionend;
    }

	public void setPromotionend(Date promotionend) {
        this.promotionend = promotionend;
    }

	public String getPromotionname() {
        return promotionname;
    }

	public void setPromotionname(String promotionname) {
        this.promotionname = promotionname;
    }

	public Date getPromotionstart() {
        return promotionstart;
    }

	public void setPromotionstart(Date promotionstart) {
        this.promotionstart = promotionstart;
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
        EntityManager em = new Promotion().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPromotions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Promotion o", Long.class).getSingleResult();
    }

	public static List<Promotion> findAllPromotions() {
        return entityManager().createQuery("SELECT o FROM Promotion o", Promotion.class).getResultList();
    }

	public static Promotion findPromotion(Integer promotionid) {
        if (promotionid == null) return null;
        return entityManager().find(Promotion.class, promotionid);
    }

	public static List<Promotion> findPromotionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Promotion o", Promotion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Promotion attached = Promotion.findPromotion(this.promotionid);
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
    public Promotion merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Promotion merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROMOTIONID")
    private Integer promotionid;

	public Integer getPromotionid() {
        return this.promotionid;
    }

	public void setPromotionid(Integer id) {
        this.promotionid = id;
    }
}
