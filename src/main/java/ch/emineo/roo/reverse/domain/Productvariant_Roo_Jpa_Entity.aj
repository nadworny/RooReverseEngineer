// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productvariant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Productvariant_Roo_Jpa_Entity {
    
    declare @type: Productvariant: @Entity;
    
    declare @type: Productvariant: @Table(name = "productvariant");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTVARIANTID")
    private Integer Productvariant.productvariantid;
    
    public Integer Productvariant.getProductvariantid() {
        return this.productvariantid;
    }
    
    public void Productvariant.setProductvariantid(Integer id) {
        this.productvariantid = id;
    }
    
}
