// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productsubcategory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Productsubcategory_Roo_Jpa_Entity {
    
    declare @type: Productsubcategory: @Entity;
    
    declare @type: Productsubcategory: @Table(name = "productsubcategory");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCTSUBCATEGORYID")
    private Integer Productsubcategory.productsubcategoryid;
    
    public Integer Productsubcategory.getProductsubcategoryid() {
        return this.productsubcategoryid;
    }
    
    public void Productsubcategory.setProductsubcategoryid(Integer id) {
        this.productsubcategoryid = id;
    }
    
}
