// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductbuildelementContent;
import ch.emineo.roo.reverse.domain.ProductbuildelementContentPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProductbuildelementContent_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ProductbuildelementContent.entityManager;
    
    public static final EntityManager ProductbuildelementContent.entityManager() {
        EntityManager em = new ProductbuildelementContent().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ProductbuildelementContent.countProductbuildelementContents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductbuildelementContent o", Long.class).getSingleResult();
    }
    
    public static List<ProductbuildelementContent> ProductbuildelementContent.findAllProductbuildelementContents() {
        return entityManager().createQuery("SELECT o FROM ProductbuildelementContent o", ProductbuildelementContent.class).getResultList();
    }
    
    public static ProductbuildelementContent ProductbuildelementContent.findProductbuildelementContent(ProductbuildelementContentPK id) {
        if (id == null) return null;
        return entityManager().find(ProductbuildelementContent.class, id);
    }
    
    public static List<ProductbuildelementContent> ProductbuildelementContent.findProductbuildelementContentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductbuildelementContent o", ProductbuildelementContent.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ProductbuildelementContent.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ProductbuildelementContent.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ProductbuildelementContent attached = ProductbuildelementContent.findProductbuildelementContent(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ProductbuildelementContent.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ProductbuildelementContent.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ProductbuildelementContent ProductbuildelementContent.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductbuildelementContent merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
