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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

@Entity
@Table(name = "purchaseditem")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "purchaseditem")
@RooDbManaged(automaticallyDelete = true)
public class Purchaseditem {
	
	public void testone() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PURCHASEDITEMID")
    private Integer purchaseditemid;

	public Integer getPurchaseditemid() {
        return this.purchaseditemid;
    }

	public void setPurchaseditemid(Integer id) {
        this.purchaseditemid = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@ManyToMany(mappedBy = "purchaseditems")
    private Set<User> users;

	@ManyToOne
    @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", referencedColumnName = "PRODUCTTHEMEID")
    private Producttheme productthemeProductthemeid;

	@ManyToOne
    @JoinColumn(name = "PRODUCTVARIANT_PRODUCTVARIANTID", referencedColumnName = "PRODUCTVARIANTID")
    private Productvariant productvariantProductvariantid;

	@ManyToOne
    @JoinColumn(name = "PRODUCT_PRODUCTID", referencedColumnName = "PRODUCTID")
    private Product productProductid;

	@ManyToOne
    @JoinColumn(name = "PROMOTIONREFERENCE_PROMOTIONID", referencedColumnName = "PROMOTIONID")
    private Promotion promotionreferencePromotionid;

	@Column(name = "ACQUISITIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date acquisitiondate;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PROMOTION")
    @NotNull
    private boolean promotion;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	@Column(name = "REMINDERSENT")
    @NotNull
    private boolean remindersent;

	@Column(name = "TYPE", length = 255)
    private String type;

	public Set<User> getUsers() {
        return users;
    }

	public void setUsers(Set<User> users) {
        this.users = users;
    }

	public Producttheme getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }

	public void setProductthemeProductthemeid(Producttheme productthemeProductthemeid) {
        this.productthemeProductthemeid = productthemeProductthemeid;
    }

	public Productvariant getProductvariantProductvariantid() {
        return productvariantProductvariantid;
    }

	public void setProductvariantProductvariantid(Productvariant productvariantProductvariantid) {
        this.productvariantProductvariantid = productvariantProductvariantid;
    }

	public Product getProductProductid() {
        return productProductid;
    }

	public void setProductProductid(Product productProductid) {
        this.productProductid = productProductid;
    }

	public Promotion getPromotionreferencePromotionid() {
        return promotionreferencePromotionid;
    }

	public void setPromotionreferencePromotionid(Promotion promotionreferencePromotionid) {
        this.promotionreferencePromotionid = promotionreferencePromotionid;
    }

	public Date getAcquisitiondate() {
        return acquisitiondate;
    }

	public void setAcquisitiondate(Date acquisitiondate) {
        this.acquisitiondate = acquisitiondate;
    }

	public boolean isOnline() {
        return online;
    }

	public void setOnline(boolean online) {
        this.online = online;
    }

	public boolean isPromotion() {
        return promotion;
    }

	public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

	public boolean isPublic1() {
        return public1;
    }

	public void setPublic1(boolean public1) {
        this.public1 = public1;
    }

	public boolean isRemindersent() {
        return remindersent;
    }

	public void setRemindersent(boolean remindersent) {
        this.remindersent = remindersent;
    }

	public String getType() {
        return type;
    }

	public void setType(String type) {
        this.type = type;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Purchaseditem().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPurchaseditems() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Purchaseditem o", Long.class).getSingleResult();
    }

	public static List<Purchaseditem> findAllPurchaseditems() {
        return entityManager().createQuery("SELECT o FROM Purchaseditem o", Purchaseditem.class).getResultList();
    }

	public static Purchaseditem findPurchaseditem(Integer purchaseditemid) {
        if (purchaseditemid == null) return null;
        return entityManager().find(Purchaseditem.class, purchaseditemid);
    }

	public static List<Purchaseditem> findPurchaseditemEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Purchaseditem o", Purchaseditem.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Purchaseditem attached = Purchaseditem.findPurchaseditem(this.purchaseditemid);
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
    public Purchaseditem merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Purchaseditem merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
