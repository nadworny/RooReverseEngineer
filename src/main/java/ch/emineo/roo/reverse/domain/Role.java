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
@Table(name = "role")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "role")
@RooDbManaged(automaticallyDelete = true)
public class Role {

	@OneToMany(mappedBy = "rolesRoleid")
    private Set<UserRole> userRoles;

	@Column(name = "NAME", length = 255, unique = true)
    private String name;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	public Set<UserRole> getUserRoles() {
        return userRoles;
    }

	public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Role().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countRoles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Role o", Long.class).getSingleResult();
    }

	public static List<Role> findAllRoles() {
        return entityManager().createQuery("SELECT o FROM Role o", Role.class).getResultList();
    }

	public static Role findRole(Integer roleid) {
        if (roleid == null) return null;
        return entityManager().find(Role.class, roleid);
    }

	public static List<Role> findRoleEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Role o", Role.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Role attached = Role.findRole(this.roleid);
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
    public Role merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Role merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLEID")
    private Integer roleid;

	public Integer getRoleid() {
        return this.roleid;
    }

	public void setRoleid(Integer id) {
        this.roleid = id;
    }
}
