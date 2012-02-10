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
@Table(name = "user_role")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = UserRolePK.class, versionField = "", table = "user_role")
@RooDbManaged(automaticallyDelete = true)
public class UserRole {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@EmbeddedId
    private UserRolePK id;

	public UserRolePK getId() {
        return this.id;
    }

	public void setId(UserRolePK id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "USER_USERID", referencedColumnName = "USERID", nullable = false, insertable = false, updatable = false)
    private User userUserid;

	@ManyToOne
    @JoinColumn(name = "ROLES_ROLEID", referencedColumnName = "ROLEID", nullable = false)
    private Role rolesRoleid;

	public User getUserUserid() {
        return userUserid;
    }

	public void setUserUserid(User userUserid) {
        this.userUserid = userUserid;
    }

	public Role getRolesRoleid() {
        return rolesRoleid;
    }

	public void setRolesRoleid(Role rolesRoleid) {
        this.rolesRoleid = rolesRoleid;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new UserRole().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countUserRoles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM UserRole o", Long.class).getSingleResult();
    }

	public static List<UserRole> findAllUserRoles() {
        return entityManager().createQuery("SELECT o FROM UserRole o", UserRole.class).getResultList();
    }

	public static UserRole findUserRole(UserRolePK id) {
        if (id == null) return null;
        return entityManager().find(UserRole.class, id);
    }

	public static List<UserRole> findUserRoleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM UserRole o", UserRole.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            UserRole attached = UserRole.findUserRole(this.id);
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
    public UserRole merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        UserRole merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
