// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.AdvancenoticeAttribute;
import ch.emineo.roo.reverse.domain.AdvancenoticeAttributePK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AdvancenoticeAttribute_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager AdvancenoticeAttribute.entityManager;
    
    public static final EntityManager AdvancenoticeAttribute.entityManager() {
        EntityManager em = new AdvancenoticeAttribute().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long AdvancenoticeAttribute.countAdvancenoticeAttributes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM AdvancenoticeAttribute o", Long.class).getSingleResult();
    }
    
    public static List<AdvancenoticeAttribute> AdvancenoticeAttribute.findAllAdvancenoticeAttributes() {
        return entityManager().createQuery("SELECT o FROM AdvancenoticeAttribute o", AdvancenoticeAttribute.class).getResultList();
    }
    
    public static AdvancenoticeAttribute AdvancenoticeAttribute.findAdvancenoticeAttribute(AdvancenoticeAttributePK id) {
        if (id == null) return null;
        return entityManager().find(AdvancenoticeAttribute.class, id);
    }
    
    public static List<AdvancenoticeAttribute> AdvancenoticeAttribute.findAdvancenoticeAttributeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM AdvancenoticeAttribute o", AdvancenoticeAttribute.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void AdvancenoticeAttribute.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void AdvancenoticeAttribute.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            AdvancenoticeAttribute attached = AdvancenoticeAttribute.findAdvancenoticeAttribute(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void AdvancenoticeAttribute.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void AdvancenoticeAttribute.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public AdvancenoticeAttribute AdvancenoticeAttribute.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        AdvancenoticeAttribute merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
