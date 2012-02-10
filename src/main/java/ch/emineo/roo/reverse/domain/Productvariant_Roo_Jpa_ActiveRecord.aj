// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productvariant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Productvariant_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Productvariant.entityManager;
    
    public static final EntityManager Productvariant.entityManager() {
        EntityManager em = new Productvariant().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Productvariant.countProductvariants() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productvariant o", Long.class).getSingleResult();
    }
    
    public static List<Productvariant> Productvariant.findAllProductvariants() {
        return entityManager().createQuery("SELECT o FROM Productvariant o", Productvariant.class).getResultList();
    }
    
    public static Productvariant Productvariant.findProductvariant(Integer productvariantid) {
        if (productvariantid == null) return null;
        return entityManager().find(Productvariant.class, productvariantid);
    }
    
    public static List<Productvariant> Productvariant.findProductvariantEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productvariant o", Productvariant.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Productvariant.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Productvariant.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Productvariant attached = Productvariant.findProductvariant(this.productvariantid);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Productvariant.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Productvariant.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Productvariant Productvariant.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productvariant merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}