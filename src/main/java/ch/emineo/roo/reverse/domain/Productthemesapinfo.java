package ch.emineo.roo.reverse.domain;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "productthemesapinfo")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "productthemesapinfo")
@RooDbManaged(automaticallyDelete = true)
public class Productthemesapinfo {

	@ManyToMany(mappedBy = "productthemesapinfoes")
    private Set<Producttheme> productthemes;

	@Column(name = "NAME", length = 255)
    @NotNull
    private String name;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	@Column(name = "SAPNUMBER")
    @NotNull
    private Long sapnumber;

	@Column(name = "WEIGHT")
    @NotNull
    private Integer weight;

	public Set<Producttheme> getProductthemes() {
        return productthemes;
    }

	public void setProductthemes(Set<Producttheme> productthemes) {
        this.productthemes = productthemes;
    }

	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
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

	public Long getSapnumber() {
        return sapnumber;
    }

	public void setSapnumber(Long sapnumber) {
        this.sapnumber = sapnumber;
    }

	public Integer getWeight() {
        return weight;
    }

	public void setWeight(Integer weight) {
        this.weight = weight;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Productthemesapinfo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countProductthemesapinfoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productthemesapinfo o", Long.class).getSingleResult();
    }

	public static List<Productthemesapinfo> findAllProductthemesapinfoes() {
        return entityManager().createQuery("SELECT o FROM Productthemesapinfo o", Productthemesapinfo.class).getResultList();
    }

	public static Productthemesapinfo findProductthemesapinfo(Integer productthemesapinfoid) {
        if (productthemesapinfoid == null) return null;
        return entityManager().find(Productthemesapinfo.class, productthemesapinfoid);
    }

	public static List<Productthemesapinfo> findProductthemesapinfoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productthemesapinfo o", Productthemesapinfo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Productthemesapinfo attached = Productthemesapinfo.findProductthemesapinfo(this.productthemesapinfoid);
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
    public Productthemesapinfo merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productthemesapinfo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTTHEMESAPINFOID")
    private Integer productthemesapinfoid;

	public Integer getProductthemesapinfoid() {
        return this.productthemesapinfoid;
    }

	public void setProductthemesapinfoid(Integer id) {
        this.productthemesapinfoid = id;
    }
}
