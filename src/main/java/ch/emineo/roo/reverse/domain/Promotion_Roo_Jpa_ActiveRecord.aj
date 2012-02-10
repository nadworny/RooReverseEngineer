// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Promotion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Promotion_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Promotion.entityManager;
    
    public static final EntityManager Promotion.entityManager() {
        EntityManager em = new Promotion().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Promotion.countPromotions() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Promotion o", Long.class).getSingleResult();
    }
    
    public static List<Promotion> Promotion.findAllPromotions() {
        return entityManager().createQuery("SELECT o FROM Promotion o", Promotion.class).getResultList();
    }
    
    public static Promotion Promotion.findPromotion(Integer promotionid) {
        if (promotionid == null) return null;
        return entityManager().find(Promotion.class, promotionid);
    }
    
    public static List<Promotion> Promotion.findPromotionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Promotion o", Promotion.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Promotion.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Promotion.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Promotion attached = Promotion.findPromotion(this.promotionid);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Promotion.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Promotion.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Promotion Promotion.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Promotion merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}