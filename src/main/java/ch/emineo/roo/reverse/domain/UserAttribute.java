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
@Table(name = "user_attribute")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = UserAttributePK.class, versionField = "", table = "user_attribute")
@RooDbManaged(automaticallyDelete = true)
public class UserAttribute {

	@EmbeddedId
    private UserAttributePK id;

	public UserAttributePK getId() {
        return this.id;
    }

	public void setId(UserAttributePK id) {
        this.id = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new UserAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countUserAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM UserAttribute o", Long.class).getSingleResult();
    }

	public static List<UserAttribute> findAllUserAttributes() {
        return entityManager().createQuery("SELECT o FROM UserAttribute o", UserAttribute.class).getResultList();
    }

	public static UserAttribute findUserAttribute(UserAttributePK id) {
        if (id == null) return null;
        return entityManager().find(UserAttribute.class, id);
    }

	public static List<UserAttribute> findUserAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM UserAttribute o", UserAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            UserAttribute attached = UserAttribute.findUserAttribute(this.id);
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
    public UserAttribute merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        UserAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@ManyToOne
    @JoinColumn(name = "USER_USERID", referencedColumnName = "USERID", nullable = false, insertable = false, updatable = false)
    private User userUserid;

	@ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute attributesAttributeid;

	public User getUserUserid() {
        return userUserid;
    }

	public void setUserUserid(User userUserid) {
        this.userUserid = userUserid;
    }

	public Attribute getAttributesAttributeid() {
        return attributesAttributeid;
    }

	public void setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
