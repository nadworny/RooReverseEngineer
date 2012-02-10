// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productthemecategory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Productthemecategory_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Productthemecategory.entityManager;
    
    public static final EntityManager Productthemecategory.entityManager() {
        EntityManager em = new Productthemecategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Productthemecategory.countProductthemecategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productthemecategory o", Long.class).getSingleResult();
    }
    
    public static List<Productthemecategory> Productthemecategory.findAllProductthemecategorys() {
        return entityManager().createQuery("SELECT o FROM Productthemecategory o", Productthemecategory.class).getResultList();
    }
    
    public static Productthemecategory Productthemecategory.findProductthemecategory(Integer productthemecategoryid) {
        if (productthemecategoryid == null) return null;
        return entityManager().find(Productthemecategory.class, productthemecategoryid);
    }
    
    public static List<Productthemecategory> Productthemecategory.findProductthemecategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productthemecategory o", Productthemecategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Productthemecategory.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Productthemecategory.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Productthemecategory attached = Productthemecategory.findProductthemecategory(this.productthemecategoryid);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Productthemecategory.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Productthemecategory.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Productthemecategory Productthemecategory.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productthemecategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
