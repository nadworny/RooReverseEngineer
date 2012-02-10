package ch.emineo.roo.reverse.domain;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "transaction")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "transaction")
@RooDbManaged(automaticallyDelete = true)
public class Transaction {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Transaction().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countTransactions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Transaction o", Long.class).getSingleResult();
    }

	public static List<Transaction> findAllTransactions() {
        return entityManager().createQuery("SELECT o FROM Transaction o", Transaction.class).getResultList();
    }

	public static Transaction findTransaction(Integer transactionid) {
        if (transactionid == null) return null;
        return entityManager().find(Transaction.class, transactionid);
    }

	public static List<Transaction> findTransactionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Transaction o", Transaction.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Transaction attached = Transaction.findTransaction(this.transactionid);
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
    public Transaction merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Transaction merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@OneToMany(mappedBy = "transactionsTransactionid")
    private Set<UserTransaction> userTransactions;

	@Column(name = "AMOUNT")
    @NotNull
    private Double amount;

	@Column(name = "DATE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date date;

	@Column(name = "MESSAGE", length = 255)
    @NotNull
    private String message;

	@Column(name = "TRANSACTIONTYPE", length = 255)
    @NotNull
    private String transactiontype;

	public Set<UserTransaction> getUserTransactions() {
        return userTransactions;
    }

	public void setUserTransactions(Set<UserTransaction> userTransactions) {
        this.userTransactions = userTransactions;
    }

	public Double getAmount() {
        return amount;
    }

	public void setAmount(Double amount) {
        this.amount = amount;
    }

	public Date getDate() {
        return date;
    }

	public void setDate(Date date) {
        this.date = date;
    }

	public String getMessage() {
        return message;
    }

	public void setMessage(String message) {
        this.message = message;
    }

	public String getTransactiontype() {
        return transactiontype;
    }

	public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTIONID")
    private Integer transactionid;

	public Integer getTransactionid() {
        return this.transactionid;
    }

	public void setTransactionid(Integer id) {
        this.transactionid = id;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
