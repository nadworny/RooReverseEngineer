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

@Entity
@Table(name = "user_transaction")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(identifierType = UserTransactionPK.class, versionField = "", table = "user_transaction")
@RooDbManaged(automaticallyDelete = true)
public class UserTransaction {

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new UserTransaction().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countUserTransactions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM UserTransaction o", Long.class).getSingleResult();
    }

	public static List<UserTransaction> findAllUserTransactions() {
        return entityManager().createQuery("SELECT o FROM UserTransaction o", UserTransaction.class).getResultList();
    }

	public static UserTransaction findUserTransaction(UserTransactionPK id) {
        if (id == null) return null;
        return entityManager().find(UserTransaction.class, id);
    }

	public static List<UserTransaction> findUserTransactionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM UserTransaction o", UserTransaction.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            UserTransaction attached = UserTransaction.findUserTransaction(this.id);
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
    public UserTransaction merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        UserTransaction merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	@EmbeddedId
    private UserTransactionPK id;

	public UserTransactionPK getId() {
        return this.id;
    }

	public void setId(UserTransactionPK id) {
        this.id = id;
    }

	@ManyToOne
    @JoinColumn(name = "USER_USERID", referencedColumnName = "USERID", nullable = false, insertable = false, updatable = false)
    private User userUserid;

	@ManyToOne
    @JoinColumn(name = "TRANSACTIONS_TRANSACTIONID", referencedColumnName = "TRANSACTIONID", nullable = false)
    private Transaction transactionsTransactionid;

	public User getUserUserid() {
        return userUserid;
    }

	public void setUserUserid(User userUserid) {
        this.userUserid = userUserid;
    }

	public Transaction getTransactionsTransactionid() {
        return transactionsTransactionid;
    }

	public void setTransactionsTransactionid(Transaction transactionsTransactionid) {
        this.transactionsTransactionid = transactionsTransactionid;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
