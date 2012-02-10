package ch.emineo.roo.reverse.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

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
}
