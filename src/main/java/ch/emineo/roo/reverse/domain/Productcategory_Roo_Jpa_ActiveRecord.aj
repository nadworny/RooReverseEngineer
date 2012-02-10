// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productcategory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Productcategory_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Productcategory.entityManager;
    
    public static final EntityManager Productcategory.entityManager() {
        EntityManager em = new Productcategory().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Productcategory.countProductcategorys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productcategory o", Long.class).getSingleResult();
    }
    
    public static List<Productcategory> Productcategory.findAllProductcategorys() {
        return entityManager().createQuery("SELECT o FROM Productcategory o", Productcategory.class).getResultList();
    }
    
    public static Productcategory Productcategory.findProductcategory(Integer productcategoryid) {
        if (productcategoryid == null) return null;
        return entityManager().find(Productcategory.class, productcategoryid);
    }
    
    public static List<Productcategory> Productcategory.findProductcategoryEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productcategory o", Productcategory.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Productcategory.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Productcategory.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Productcategory attached = Productcategory.findProductcategory(this.productcategoryid);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Productcategory.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Productcategory.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Productcategory Productcategory.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productcategory merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}