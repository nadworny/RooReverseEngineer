// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Attribute_Roo_Jpa_Entity {
    
    declare @type: Attribute: @Entity;
    
    declare @type: Attribute: @Table(name = "attribute");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ATTRIBUTEID")
    private Long Attribute.attributeid;
    
    public Long Attribute.getAttributeid() {
        return this.attributeid;
    }
    
    public void Attribute.setAttributeid(Long id) {
        this.attributeid = id;
    }
    
}