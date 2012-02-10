package ch.emineo.roo.reverse.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "message")
@Configurable
@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "", table = "message")
@RooDbManaged(automaticallyDelete = true)
public class Message {

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Column(name = "CREATIONTIME")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date creationtime;

	@Column(name = "MESSAGETEXT")
    @NotNull
    private String messagetext;

	@Column(name = "ONLINE")
    @NotNull
    private boolean online;

	@Column(name = "PUBLIC")
    @NotNull
    private boolean public1;

	@Column(name = "RECIPIENT", length = 255)
    private String recipient;

	@Column(name = "SUBJECT", length = 255)
    @NotNull
    private String subject;

	public Date getCreationtime() {
        return creationtime;
    }

	public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

	public String getMessagetext() {
        return messagetext;
    }

	public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
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

	public String getRecipient() {
        return recipient;
    }

	public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

	public String getSubject() {
        return subject;
    }

	public void setSubject(String subject) {
        this.subject = subject;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MESSAGEID")
    private Integer messageid;

	public Integer getMessageid() {
        return this.messageid;
    }

	public void setMessageid(Integer id) {
        this.messageid = id;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Message().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countMessages() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Message o", Long.class).getSingleResult();
    }

	public static List<Message> findAllMessages() {
        return entityManager().createQuery("SELECT o FROM Message o", Message.class).getResultList();
    }

	public static Message findMessage(Integer messageid) {
        if (messageid == null) return null;
        return entityManager().find(Message.class, messageid);
    }

	public static List<Message> findMessageEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Message o", Message.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
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
            Message attached = Message.findMessage(this.messageid);
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
    public Message merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Message merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
