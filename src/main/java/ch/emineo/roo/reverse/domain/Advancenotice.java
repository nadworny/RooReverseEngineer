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
@Table(name = "advancenotice")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "advancenotice")
@RooDbManaged(automaticallyDelete = true)
public class Advancenotice {

	@OneToMany(mappedBy = "advancenoticeAdvancenoticeid")
    private Set<AdvancenoticeAttribute> advancenoticeAttributes;

	@Column(name = "ADVANCENOTICESTART")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date advancenoticestart;

	@Column(name = "ADVANCENOTICEEND")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date advancenoticeend;

	@Column(name = "ONLINE")
    @NotNull
    private Short online;

	@Column(name = "PUBLIC")
    @NotNull
    private Short public1;

	public Set<AdvancenoticeAttribute> getAdvancenoticeAttributes() {
        return advancenoticeAttributes;
    }

	public void setAdvancenoticeAttributes(Set<AdvancenoticeAttribute> advancenoticeAttributes) {
        this.advancenoticeAttributes = advancenoticeAttributes;
    }

	public Date getAdvancenoticestart() {
        return advancenoticestart;
    }

	public void setAdvancenoticestart(Date advancenoticestart) {
        this.advancenoticestart = advancenoticestart;
    }

	public Date getAdvancenoticeend() {
        return advancenoticeend;
    }

	public void setAdvancenoticeend(Date advancenoticeend) {
        this.advancenoticeend = advancenoticeend;
    }

	public Short getOnline() {
        return online;
    }

	public void setOnline(Short online) {
        this.online = online;
    }

	public Short getPublic1() {
        return public1;
    }

	public void setPublic1(Short public1) {
        this.public1 = public1;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADVANCENOTICEID")
    private Integer advancenoticeid;

	public Integer getAdvancenoticeid() {
        return this.advancenoticeid;
    }

	public void setAdvancenoticeid(Integer id) {
        this.advancenoticeid = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Advancenotice().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAdvancenotices() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Advancenotice o", Long.class).getSingleResult();
    }

	public static List<Advancenotice> findAllAdvancenotices() {
        return entityManager().createQuery("SELECT o FROM Advancenotice o", Advancenotice.class).getResultList();
    }

	public static Advancenotice findAdvancenotice(Integer advancenoticeid) {
        if (advancenoticeid == null) return null;
        return entityManager().find(Advancenotice.class, advancenoticeid);
    }

	public static List<Advancenotice> findAdvancenoticeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Advancenotice o", Advancenotice.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Advancenotice attached = Advancenotice.findAdvancenotice(this.advancenoticeid);
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
    public Advancenotice merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Advancenotice merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
