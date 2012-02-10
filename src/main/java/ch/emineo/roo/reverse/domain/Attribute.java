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
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "attribute")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "attribute")
@RooDbManaged(automaticallyDelete = true)
public class Attribute {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ATTRIBUTEID")
    private Long attributeid;

	public Long getAttributeid() {
        return this.attributeid;
    }

	public void setAttributeid(Long id) {
        this.attributeid = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<AdvancenoticeAttribute> advancenoticeAttributes;

	@OneToMany(mappedBy = "descriptionAttributeid")
    private Set<Content> contents;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductAttribute> productAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductbuildAttribute> productbuildAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductbuildelementAttribute> productbuildelementAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductcategoryAttribute> productcategoryAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductsubcategoryAttribute> productsubcategoryAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductthemeAttribute> productthemeAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductthemecategoryAttribute> productthemecategoryAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductthemecontentholderAttribute> productthemecontentholderAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<ProductthemesubcategoryAttribute> productthemesubcategoryAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<SubscriptiontypeAttribute> subscriptiontypeAttributes;

	@OneToMany(mappedBy = "attributesAttributeid")
    private Set<UserAttribute> userAttributes;

	@Column(name = "LANGUAGE", length = 255)
    private String language;

	@Column(name = "TYPE", length = 255)
    private String type;

	@Column(name = "VALUE")
    private String value;

	public Set<AdvancenoticeAttribute> getAdvancenoticeAttributes() {
        return advancenoticeAttributes;
    }

	public void setAdvancenoticeAttributes(Set<AdvancenoticeAttribute> advancenoticeAttributes) {
        this.advancenoticeAttributes = advancenoticeAttributes;
    }

	public Set<Content> getContents() {
        return contents;
    }

	public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

	public Set<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

	public void setProductAttributes(Set<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

	public Set<ProductbuildAttribute> getProductbuildAttributes() {
        return productbuildAttributes;
    }

	public void setProductbuildAttributes(Set<ProductbuildAttribute> productbuildAttributes) {
        this.productbuildAttributes = productbuildAttributes;
    }

	public Set<ProductbuildelementAttribute> getProductbuildelementAttributes() {
        return productbuildelementAttributes;
    }

	public void setProductbuildelementAttributes(Set<ProductbuildelementAttribute> productbuildelementAttributes) {
        this.productbuildelementAttributes = productbuildelementAttributes;
    }

	public Set<ProductcategoryAttribute> getProductcategoryAttributes() {
        return productcategoryAttributes;
    }

	public void setProductcategoryAttributes(Set<ProductcategoryAttribute> productcategoryAttributes) {
        this.productcategoryAttributes = productcategoryAttributes;
    }

	public Set<ProductsubcategoryAttribute> getProductsubcategoryAttributes() {
        return productsubcategoryAttributes;
    }

	public void setProductsubcategoryAttributes(Set<ProductsubcategoryAttribute> productsubcategoryAttributes) {
        this.productsubcategoryAttributes = productsubcategoryAttributes;
    }

	public Set<ProductthemeAttribute> getProductthemeAttributes() {
        return productthemeAttributes;
    }

	public void setProductthemeAttributes(Set<ProductthemeAttribute> productthemeAttributes) {
        this.productthemeAttributes = productthemeAttributes;
    }

	public Set<ProductthemecategoryAttribute> getProductthemecategoryAttributes() {
        return productthemecategoryAttributes;
    }

	public void setProductthemecategoryAttributes(Set<ProductthemecategoryAttribute> productthemecategoryAttributes) {
        this.productthemecategoryAttributes = productthemecategoryAttributes;
    }

	public Set<ProductthemecontentholderAttribute> getProductthemecontentholderAttributes() {
        return productthemecontentholderAttributes;
    }

	public void setProductthemecontentholderAttributes(Set<ProductthemecontentholderAttribute> productthemecontentholderAttributes) {
        this.productthemecontentholderAttributes = productthemecontentholderAttributes;
    }

	public Set<ProductthemesubcategoryAttribute> getProductthemesubcategoryAttributes() {
        return productthemesubcategoryAttributes;
    }

	public void setProductthemesubcategoryAttributes(Set<ProductthemesubcategoryAttribute> productthemesubcategoryAttributes) {
        this.productthemesubcategoryAttributes = productthemesubcategoryAttributes;
    }

	public Set<SubscriptiontypeAttribute> getSubscriptiontypeAttributes() {
        return subscriptiontypeAttributes;
    }

	public void setSubscriptiontypeAttributes(Set<SubscriptiontypeAttribute> subscriptiontypeAttributes) {
        this.subscriptiontypeAttributes = subscriptiontypeAttributes;
    }

	public Set<UserAttribute> getUserAttributes() {
        return userAttributes;
    }

	public void setUserAttributes(Set<UserAttribute> userAttributes) {
        this.userAttributes = userAttributes;
    }

	public String getLanguage() {
        return language;
    }

	public void setLanguage(String language) {
        this.language = language;
    }

	public String getType() {
        return type;
    }

	public void setType(String type) {
        this.type = type;
    }

	public String getValue() {
        return value;
    }

	public void setValue(String value) {
        this.value = value;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Attribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Attribute o", Long.class).getSingleResult();
    }

	public static List<Attribute> findAllAttributes() {
        return entityManager().createQuery("SELECT o FROM Attribute o", Attribute.class).getResultList();
    }

	public static Attribute findAttribute(Long attributeid) {
        if (attributeid == null) return null;
        return entityManager().find(Attribute.class, attributeid);
    }

	public static List<Attribute> findAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Attribute o", Attribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Attribute attached = Attribute.findAttribute(this.attributeid);
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
    public Attribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Attribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
