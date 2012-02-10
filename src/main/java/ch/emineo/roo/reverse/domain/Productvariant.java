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
@Table(name = "productvariant")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productvariant")
@RooDbManaged(automaticallyDelete = true)
public class Productvariant {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTVARIANTID")
    private Integer productvariantid;

	public Integer getProductvariantid() {
        return this.productvariantid;
    }

	public void setProductvariantid(Integer id) {
        this.productvariantid = id;
    }

	@OneToMany(mappedBy = "variantsProductvariantid")
    private Set<ProductProductvariant> productProductvariants;

	@OneToMany(mappedBy = "variantsProductvariantid")
    private Set<ProductthemeProductvariant> productthemeProductvariants;

	@OneToMany(mappedBy = "productvariantProductvariantid")
    private Set<Purchaseditem> purchaseditems;

	@ManyToOne
    @JoinColumn(name = "SUBSCRIPTIONTYPE_MONTHS", referencedColumnName = "MONTHS")
    private Subscriptiontype subscriptiontypeMonths;

	@Column(name = "FREE")
    @NotNull
    private boolean free;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PRICE")
    @NotNull
    private Double price;

	@Column(name = "PUBLISH")
    @NotNull
    private boolean publish;

	public Set<ProductProductvariant> getProductProductvariants() {
        return productProductvariants;
    }

	public void setProductProductvariants(Set<ProductProductvariant> productProductvariants) {
        this.productProductvariants = productProductvariants;
    }

	public Set<ProductthemeProductvariant> getProductthemeProductvariants() {
        return productthemeProductvariants;
    }

	public void setProductthemeProductvariants(Set<ProductthemeProductvariant> productthemeProductvariants) {
        this.productthemeProductvariants = productthemeProductvariants;
    }

	public Set<Purchaseditem> getPurchaseditems() {
        return purchaseditems;
    }

	public void setPurchaseditems(Set<Purchaseditem> purchaseditems) {
        this.purchaseditems = purchaseditems;
    }

	public Subscriptiontype getSubscriptiontypeMonths() {
        return subscriptiontypeMonths;
    }

	public void setSubscriptiontypeMonths(Subscriptiontype subscriptiontypeMonths) {
        this.subscriptiontypeMonths = subscriptiontypeMonths;
    }

	public boolean isFree() {
        return free;
    }

	public void setFree(boolean free) {
        this.free = free;
    }

	public boolean isOnline() {
        return online;
    }

	public void setOnline(boolean online) {
        this.online = online;
    }

	public Double getPrice() {
        return price;
    }

	public void setPrice(Double price) {
        this.price = price;
    }

	public boolean isPublish() {
        return publish;
    }

	public void setPublish(boolean publish) {
        this.publish = publish;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productvariant().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductvariants() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productvariant o", Long.class).getSingleResult();
    }

	public static List<Productvariant> findAllProductvariants() {
        return entityManager().createQuery("SELECT o FROM Productvariant o", Productvariant.class).getResultList();
    }

	public static Productvariant findProductvariant(Integer productvariantid) {
        if (productvariantid == null) return null;
        return entityManager().find(Productvariant.class, productvariantid);
    }

	public static List<Productvariant> findProductvariantEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productvariant o", Productvariant.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productvariant attached = Productvariant.findProductvariant(this.productvariantid);
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
    public Productvariant merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productvariant merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
