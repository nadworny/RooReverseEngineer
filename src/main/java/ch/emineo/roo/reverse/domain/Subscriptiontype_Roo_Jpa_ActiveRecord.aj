// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Subscriptiontype;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Subscriptiontype_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Subscriptiontype.entityManager;
    
    public static final EntityManager Subscriptiontype.entityManager() {
        EntityManager em = new Subscriptiontype().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Subscriptiontype.countSubscriptiontypes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Subscriptiontype o", Long.class).getSingleResult();
    }
    
    public static List<Subscriptiontype> Subscriptiontype.findAllSubscriptiontypes() {
        return entityManager().createQuery("SELECT o FROM Subscriptiontype o", Subscriptiontype.class).getResultList();
    }
    
    public static Subscriptiontype Subscriptiontype.findSubscriptiontype(Integer months) {
        if (months == null) return null;
        return entityManager().find(Subscriptiontype.class, months);
    }
    
    public static List<Subscriptiontype> Subscriptiontype.findSubscriptiontypeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Subscriptiontype o", Subscriptiontype.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Subscriptiontype.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Subscriptiontype.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Subscriptiontype attached = Subscriptiontype.findSubscriptiontype(this.months);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Subscriptiontype.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Subscriptiontype.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Subscriptiontype Subscriptiontype.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Subscriptiontype merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}