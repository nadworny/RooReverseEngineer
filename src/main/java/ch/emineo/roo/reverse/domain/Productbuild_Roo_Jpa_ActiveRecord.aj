// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productbuild;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Productbuild_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Productbuild.entityManager;
    
    public static final EntityManager Productbuild.entityManager() {
        EntityManager em = new Productbuild().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Productbuild.countProductbuilds() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Productbuild o", Long.class).getSingleResult();
    }
    
    public static List<Productbuild> Productbuild.findAllProductbuilds() {
        return entityManager().createQuery("SELECT o FROM Productbuild o", Productbuild.class).getResultList();
    }
    
    public static Productbuild Productbuild.findProductbuild(Integer productbuildid) {
        if (productbuildid == null) return null;
        return entityManager().find(Productbuild.class, productbuildid);
    }
    
    public static List<Productbuild> Productbuild.findProductbuildEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Productbuild o", Productbuild.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Productbuild.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Productbuild.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Productbuild attached = Productbuild.findProductbuild(this.productbuildid);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Productbuild.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Productbuild.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Productbuild Productbuild.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Productbuild merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
