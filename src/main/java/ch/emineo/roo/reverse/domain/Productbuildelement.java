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

@Configurable
@Entity
@Table(name = "productbuildelement")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productbuildelement")
@RooDbManaged(automaticallyDelete = true)
public class Productbuildelement {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productbuildelement().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductbuildelements() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productbuildelement o", Long.class).getSingleResult();
    }

	public static List<Productbuildelement> findAllProductbuildelements() {
        return entityManager().createQuery("SELECT o FROM Productbuildelement o", Productbuildelement.class).getResultList();
    }

	public static Productbuildelement findProductbuildelement(Integer productbuildelementid) {
        if (productbuildelementid == null) return null;
        return entityManager().find(Productbuildelement.class, productbuildelementid);
    }

	public static List<Productbuildelement> findProductbuildelementEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productbuildelement o", Productbuildelement.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productbuildelement attached = Productbuildelement.findProductbuildelement(this.productbuildelementid);
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
    public Productbuildelement merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productbuildelement merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@OneToMany(mappedBy = "productbuildelementsProductbuildelementid")
    private Set<ProductbuildProductbuildelement> productbuildProductbuildelements;

	@OneToMany(mappedBy = "productbuildelementProductbuildelementid")
    private Set<ProductbuildelementAttribute> productbuildelementAttributes;

	@OneToMany(mappedBy = "productbuildelementProductbuildelementid")
    private Set<ProductbuildelementContent> productbuildelementContents;

	@Column(name = "CONTENTTYPE", length = 255)
    @NotNull
    private String contenttype;

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

	public Set<ProductbuildProductbuildelement> getProductbuildProductbuildelements() {
        return productbuildProductbuildelements;
    }

	public void setProductbuildProductbuildelements(Set<ProductbuildProductbuildelement> productbuildProductbuildelements) {
        this.productbuildProductbuildelements = productbuildProductbuildelements;
    }

	public Set<ProductbuildelementAttribute> getProductbuildelementAttributes() {
        return productbuildelementAttributes;
    }

	public void setProductbuildelementAttributes(Set<ProductbuildelementAttribute> productbuildelementAttributes) {
        this.productbuildelementAttributes = productbuildelementAttributes;
    }

	public Set<ProductbuildelementContent> getProductbuildelementContents() {
        return productbuildelementContents;
    }

	public void setProductbuildelementContents(Set<ProductbuildelementContent> productbuildelementContents) {
        this.productbuildelementContents = productbuildelementContents;
    }

	public String getContenttype() {
        return contenttype;
    }

	public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
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

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTBUILDELEMENTID")
    private Integer productbuildelementid;

	public Integer getProductbuildelementid() {
        return this.productbuildelementid;
    }

	public void setProductbuildelementid(Integer id) {
        this.productbuildelementid = id;
    }
}
