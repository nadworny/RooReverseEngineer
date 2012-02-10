package ch.emineo.roo.reverse.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "promotioncode")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "promotioncode")
@RooDbManaged(automaticallyDelete = true)
public class Promotioncode {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Promotioncode().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countPromotioncodes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Promotioncode o", Long.class).getSingleResult();
    }

	public static List<Promotioncode> findAllPromotioncodes() {
        return entityManager().createQuery("SELECT o FROM Promotioncode o", Promotioncode.class).getResultList();
    }

	public static Promotioncode findPromotioncode(String promotioncodeid) {
        if (promotioncodeid == null || promotioncodeid.length() == 0) return null;
        return entityManager().find(Promotioncode.class, promotioncodeid);
    }

	public static List<Promotioncode> findPromotioncodeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Promotioncode o", Promotioncode.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Promotioncode attached = Promotioncode.findPromotioncode(this.promotioncodeid);
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
    public Promotioncode merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Promotioncode merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROMOTIONCODEID", length = 255)
    private String promotioncodeid;

	public String getPromotioncodeid() {
        return this.promotioncodeid;
    }

	public void setPromotioncodeid(String id) {
        this.promotioncodeid = id;
    }

	@ManyToOne
    @JoinColumn(name = "USER_FK", referencedColumnName = "USERID")
    private User userFk;

	@ManyToOne
    @JoinColumn(name = "PROMOTION_FK", referencedColumnName = "PROMOTIONID")
    private Promotion promotionFk;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public User getUserFk() {
        return userFk;
    }

	public void setUserFk(User userFk) {
        this.userFk = userFk;
    }

	public Promotion getPromotionFk() {
        return promotionFk;
    }

	public void setPromotionFk(Promotion promotionFk) {
        this.promotionFk = promotionFk;
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
