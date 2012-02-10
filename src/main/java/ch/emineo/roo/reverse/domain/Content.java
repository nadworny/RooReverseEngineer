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
@Table(name = "content")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "content")
@RooDbManaged(automaticallyDelete = true)
public class Content {

	@OneToMany(mappedBy = "contentsContentid")
    private Set<ProductbuildelementContent> productbuildelementContents;

	@ManyToOne
    @JoinColumn(name = "DELIVERYINFO_FK", referencedColumnName = "DELIVERYINFOID")
    private Deliveryinfo deliveryinfoFk;

	@ManyToOne
    @JoinColumn(name = "DESCRIPTION_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID")
    private Attribute descriptionAttributeid;

	@Column(name = "CONTENTDELIVERYTYPE", length = 255)
    @NotNull
    private String contentdeliverytype;

	@Column(name = "DELIVERYTIME")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date deliverytime;

	@Column(name = "LANGUAGE", length = 255)
    @NotNull
    private String language;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	@Column(name = "SAMPLE")
    @NotNull
    private boolean sample;

	public Set<ProductbuildelementContent> getProductbuildelementContents() {
        return productbuildelementContents;
    }

	public void setProductbuildelementContents(Set<ProductbuildelementContent> productbuildelementContents) {
        this.productbuildelementContents = productbuildelementContents;
    }

	public Deliveryinfo getDeliveryinfoFk() {
        return deliveryinfoFk;
    }

	public void setDeliveryinfoFk(Deliveryinfo deliveryinfoFk) {
        this.deliveryinfoFk = deliveryinfoFk;
    }

	public Attribute getDescriptionAttributeid() {
        return descriptionAttributeid;
    }

	public void setDescriptionAttributeid(Attribute descriptionAttributeid) {
        this.descriptionAttributeid = descriptionAttributeid;
    }

	public String getContentdeliverytype() {
        return contentdeliverytype;
    }

	public void setContentdeliverytype(String contentdeliverytype) {
        this.contentdeliverytype = contentdeliverytype;
    }

	public Date getDeliverytime() {
        return deliverytime;
    }

	public void setDeliverytime(Date deliverytime) {
        this.deliverytime = deliverytime;
    }

	public String getLanguage() {
        return language;
    }

	public void setLanguage(String language) {
        this.language = language;
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

	public boolean isSample() {
        return sample;
    }

	public void setSample(boolean sample) {
        this.sample = sample;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTENTID", length = 255)
    private String contentid;

	public String getContentid() {
        return this.contentid;
    }

	public void setContentid(String id) {
        this.contentid = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Content().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countContents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Content o", Long.class).getSingleResult();
    }

	public static List<Content> findAllContents() {
        return entityManager().createQuery("SELECT o FROM Content o", Content.class).getResultList();
    }

	public static Content findContent(String contentid) {
        if (contentid == null || contentid.length() == 0) return null;
        return entityManager().find(Content.class, contentid);
    }

	public static List<Content> findContentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Content o", Content.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Content attached = Content.findContent(this.contentid);
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
    public Content merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Content merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
