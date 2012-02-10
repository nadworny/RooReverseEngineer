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

@Entity
@Table(name = "subscriptiontype")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "subscriptiontype")
@RooDbManaged(automaticallyDelete = true)
public class Subscriptiontype {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MONTHS")
    private Integer months;

	public Integer getMonths() {
        return this.months;
    }

	public void setMonths(Integer id) {
        this.months = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Subscriptiontype().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countSubscriptiontypes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Subscriptiontype o", Long.class).getSingleResult();
    }

	public static List<Subscriptiontype> findAllSubscriptiontypes() {
        return entityManager().createQuery("SELECT o FROM Subscriptiontype o", Subscriptiontype.class).getResultList();
    }

	public static Subscriptiontype findSubscriptiontype(Integer months) {
        if (months == null) return null;
        return entityManager().find(Subscriptiontype.class, months);
    }

	public static List<Subscriptiontype> findSubscriptiontypeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Subscriptiontype o", Subscriptiontype.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Subscriptiontype attached = Subscriptiontype.findSubscriptiontype(this.months);
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
    public Subscriptiontype merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Subscriptiontype merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@OneToMany(mappedBy = "subscriptiontypeMonths")
    private Set<Productvariant> productvariants;

	@OneToMany(mappedBy = "subscriptiontypeMonths")
    private Set<SubscriptiontypeAttribute> subscriptiontypeAttributes;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLISH")
    @NotNull
    private boolean publish;

	public Set<Productvariant> getProductvariants() {
        return productvariants;
    }

	public void setProductvariants(Set<Productvariant> productvariants) {
        this.productvariants = productvariants;
    }

	public Set<SubscriptiontypeAttribute> getSubscriptiontypeAttributes() {
        return subscriptiontypeAttributes;
    }

	public void setSubscriptiontypeAttributes(Set<SubscriptiontypeAttribute> subscriptiontypeAttributes) {
        this.subscriptiontypeAttributes = subscriptiontypeAttributes;
    }

	public boolean isOnline() {
        return online;
    }

	public void setOnline(boolean online) {
        this.online = online;
    }

	public boolean isPublish() {
        return publish;
    }

	public void setPublish(boolean publish) {
        this.publish = publish;
    }
}
