// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductAttribute;
import ch.emineo.roo.reverse.domain.ProductAttributePK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect ProductAttribute_Roo_Jpa_Entity {
    
    declare @type: ProductAttribute: @Entity;
    
    declare @type: ProductAttribute: @Table(name = "product_attribute");
    
    @EmbeddedId
    private ProductAttributePK ProductAttribute.id;
    
    public ProductAttributePK ProductAttribute.getId() {
        return this.id;
    }
    
    public void ProductAttribute.setId(ProductAttributePK id) {
        this.id = id;
    }
    
}