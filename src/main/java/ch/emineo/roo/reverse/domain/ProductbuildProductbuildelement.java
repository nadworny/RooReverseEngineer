package ch.emineo.roo.reverse.domain;

import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@Configurable
@Entity
@Table(name = "productbuild_productbuildelement")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = ProductbuildProductbuildelementPK.class, versionField = "", table = "productbuild_productbuildelement")
@RooDbManaged(automaticallyDelete = true)
public class ProductbuildProductbuildelement {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new ProductbuildProductbuildelement().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductbuildProductbuildelements() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductbuildProductbuildelement o", Long.class).getSingleResult();
    }

	public static List<ProductbuildProductbuildelement> findAllProductbuildProductbuildelements() {
        return entityManager().createQuery("SELECT o FROM ProductbuildProductbuildelement o", ProductbuildProductbuildelement.class).getResultList();
    }

	public static ProductbuildProductbuildelement findProductbuildProductbuildelement(ProductbuildProductbuildelementPK id) {
        if (id == null) return null;
        return entityManager().find(ProductbuildProductbuildelement.class, id);
    }

	public static List<ProductbuildProductbuildelement> findProductbuildProductbuildelementEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductbuildProductbuildelement o", ProductbuildProductbuildelement.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            ProductbuildProductbuildelement attached = ProductbuildProductbuildelement.findProductbuildProductbuildelement(this.id);
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
    public ProductbuildProductbuildelement merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductbuildProductbuildelement merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@EmbeddedId
    private ProductbuildProductbuildelementPK id;

	public ProductbuildProductbuildelementPK getId() {
        return this.id;
    }

	public void setId(ProductbuildProductbuildelementPK id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "PRODUCTBUILD_PRODUCTBUILDID", referencedColumnName = "PRODUCTBUILDID", nullable = false, insertable = false, updatable = false)
    private Productbuild productbuildProductbuildid;

	@ManyToOne
    @JoinColumn(name = "PRODUCTBUILDELEMENTS_PRODUCTBUILDELEMENTID", referencedColumnName = "PRODUCTBUILDELEMENTID", nullable = false)
    private Productbuildelement productbuildelementsProductbuildelementid;

	public Productbuild getProductbuildProductbuildid() {
        return productbuildProductbuildid;
    }

	public void setProductbuildProductbuildid(Productbuild productbuildProductbuildid) {
        this.productbuildProductbuildid = productbuildProductbuildid;
    }

	public Productbuildelement getProductbuildelementsProductbuildelementid() {
        return productbuildelementsProductbuildelementid;
    }

	public void setProductbuildelementsProductbuildelementid(Productbuildelement productbuildelementsProductbuildelementid) {
        this.productbuildelementsProductbuildelementid = productbuildelementsProductbuildelementid;
    }
}
