// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductthemecategoryProductthemesubcategory;
import ch.emineo.roo.reverse.domain.ProductthemecategoryProductthemesubcategoryPK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect ProductthemecategoryProductthemesubcategory_Roo_Jpa_Entity {
    
    declare @type: ProductthemecategoryProductthemesubcategory: @Entity;
    
    declare @type: ProductthemecategoryProductthemesubcategory: @Table(name = "productthemecategory_productthemesubcategory");
    
    @EmbeddedId
    private ProductthemecategoryProductthemesubcategoryPK ProductthemecategoryProductthemesubcategory.id;
    
    public ProductthemecategoryProductthemesubcategoryPK ProductthemecategoryProductthemesubcategory.getId() {
        return this.id;
    }
    
    public void ProductthemecategoryProductthemesubcategory.setId(ProductthemecategoryProductthemesubcategoryPK id) {
        this.id = id;
    }
    
}