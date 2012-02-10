package ch.emineo.roo.reverse.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@Table(name = "user")
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "user")
public class User {

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_purchaseditem", joinColumns = { @JoinColumn(name = "USER_USERID", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "PURCHASEDITEMS_PURCHASEDITEMID", nullable = false) })
	private Set<Purchaseditem> purchaseditems;

	@OneToMany(mappedBy = "userFk", fetch = FetchType.LAZY)
	private Set<Promotioncode> promotioncodes;

	@OneToMany(mappedBy = "userUserid", fetch = FetchType.LAZY)
	private Set<UserAttribute> userAttributes;

	@OneToMany(mappedBy = "userUserid", fetch = FetchType.LAZY)
	private Set<UserRole> userRoles;

	@OneToMany(mappedBy = "userUserid", fetch = FetchType.LAZY)
	private Set<UserTransaction> userTransactions;

	@Column(name = "CANPAYBYBILL")
	@NotNull
	private boolean canpaybybill;

	@Column(name = "CITY", length = 255)
	private String city;

	@Column(name = "COMPANY", length = 255)
	private String company;

	@Column(name = "CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date created;

	@Column(name = "EMAIL", length = 255)
	@NotNull
	private String email;

	@Column(name = "FIRSTNAME", length = 255)
	private String firstname;

	@Column(name = "FON", length = 255)
	private String fon;

	@Column(name = "LASTNAME", length = 255)
	private String lastname;

	@Column(name = "LICENCENUMBER", length = 255)
	private String licencenumber;

	@Column(name = "MISSEDLOGINS")
	@NotNull
	private Integer missedlogins;

	@Column(name = "MOBILE", length = 255)
	private String mobile;

	@Column(name = "ONLINE")
	@NotNull
	private boolean online;

	@Column(name = "PASSWORD")
	private byte[] password;

	@Column(name = "PLZ", length = 255)
	private String plz;

	@Column(name = "PUBLIC")
	@NotNull
	private boolean public1;

	@Column(name = "SALUTATION", length = 255)
	private String salutation;

	@Column(name = "STREET", length = 255)
	private String street;

	@Column(name = "USERNAME", length = 255, unique = true)
	@NotNull
	private String username;

	public Set<Purchaseditem> getPurchaseditems() {
		return purchaseditems;
	}

	public void setPurchaseditems(Set<Purchaseditem> purchaseditems) {
		this.purchaseditems = purchaseditems;
	}

	public Set<Promotioncode> getPromotioncodes() {
		return promotioncodes;
	}

	public void setPromotioncodes(Set<Promotioncode> promotioncodes) {
		this.promotioncodes = promotioncodes;
	}

	public Set<UserAttribute> getUserAttributes() {
		return userAttributes;
	}

	public void setUserAttributes(Set<UserAttribute> userAttributes) {
		this.userAttributes = userAttributes;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<UserTransaction> getUserTransactions() {
		return userTransactions;
	}

	public void setUserTransactions(Set<UserTransaction> userTransactions) {
		this.userTransactions = userTransactions;
	}

	public boolean isCanpaybybill() {
		return canpaybybill;
	}

	public void setCanpaybybill(boolean canpaybybill) {
		this.canpaybybill = canpaybybill;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFon() {
		return fon;
	}

	public void setFon(String fon) {
		this.fon = fon;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLicencenumber() {
		return licencenumber;
	}

	public void setLicencenumber(String licencenumber) {
		this.licencenumber = licencenumber;
	}

	public Integer getMissedlogins() {
		return missedlogins;
	}

	public void setMissedlogins(Integer missedlogins) {
		this.missedlogins = missedlogins;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public boolean isPublic1() {
		return public1;
	}

	public void setPublic1(boolean public1) {
		this.public1 = public1;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID")
    private Integer userid;

	public Integer getUserid() {
        return this.userid;
    }

	public void setUserid(Integer id) {
        this.userid = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new User().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countUsers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM User o", Long.class).getSingleResult();
    }

	public static List<User> findAllUsers() {
        return entityManager().createQuery("SELECT o FROM User o", User.class).getResultList();
    }

	public static User findUser(Integer userid) {
        if (userid == null) return null;
        return entityManager().find(User.class, userid);
    }

	public static List<User> findUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM User o", User.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            User attached = User.findUser(this.userid);
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
    public User merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        User merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
