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
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "deliveryinfo")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "deliveryinfo")
@RooDbManaged(automaticallyDelete = true)
public class Deliveryinfo {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Deliveryinfo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countDeliveryinfoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Deliveryinfo o", Long.class).getSingleResult();
    }

	public static List<Deliveryinfo> findAllDeliveryinfoes() {
        return entityManager().createQuery("SELECT o FROM Deliveryinfo o", Deliveryinfo.class).getResultList();
    }

	public static Deliveryinfo findDeliveryinfo(Integer deliveryinfoid) {
        if (deliveryinfoid == null) return null;
        return entityManager().find(Deliveryinfo.class, deliveryinfoid);
    }

	public static List<Deliveryinfo> findDeliveryinfoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Deliveryinfo o", Deliveryinfo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Deliveryinfo attached = Deliveryinfo.findDeliveryinfo(this.deliveryinfoid);
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
    public Deliveryinfo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Deliveryinfo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@OneToMany(mappedBy = "deliveryinfoFk")
    private Set<Content> contents;

	@Column(name = "DELIVERYINTERVAL")
    private Integer deliveryinterval;

	@Column(name = "DELIVERYREFERENCETYPE")
    private Integer deliveryreferencetype;

	@Column(name = "ELAPSETIMESPAN")
    private Integer elapsetimespan;

	@Column(name = "VALIDTIMESPAN")
    private Integer validtimespan;

	@Column(name = "SEASONSTART")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date seasonstart;

	@Column(name = "SEASONEND")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date seasonend;

	@Column(name = "DELIVERYTIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date deliverytimestamp;

	public Set<Content> getContents() {
        return contents;
    }

	public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

	public Integer getDeliveryinterval() {
        return deliveryinterval;
    }

	public void setDeliveryinterval(Integer deliveryinterval) {
        this.deliveryinterval = deliveryinterval;
    }

	public Integer getDeliveryreferencetype() {
        return deliveryreferencetype;
    }

	public void setDeliveryreferencetype(Integer deliveryreferencetype) {
        this.deliveryreferencetype = deliveryreferencetype;
    }

	public Integer getElapsetimespan() {
        return elapsetimespan;
    }

	public void setElapsetimespan(Integer elapsetimespan) {
        this.elapsetimespan = elapsetimespan;
    }

	public Integer getValidtimespan() {
        return validtimespan;
    }

	public void setValidtimespan(Integer validtimespan) {
        this.validtimespan = validtimespan;
    }

	public Date getSeasonstart() {
        return seasonstart;
    }

	public void setSeasonstart(Date seasonstart) {
        this.seasonstart = seasonstart;
    }

	public Date getSeasonend() {
        return seasonend;
    }

	public void setSeasonend(Date seasonend) {
        this.seasonend = seasonend;
    }

	public Date getDeliverytimestamp() {
        return deliverytimestamp;
    }

	public void setDeliverytimestamp(Date deliverytimestamp) {
        this.deliverytimestamp = deliverytimestamp;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DELIVERYINFOID")
    private Integer deliveryinfoid;

	public Integer getDeliveryinfoid() {
        return this.deliveryinfoid;
    }

	public void setDeliveryinfoid(Integer id) {
        this.deliveryinfoid = id;
    }
}
