// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Producttheme;
import ch.emineo.roo.reverse.domain.ProductthemeAttribute;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect ProductthemeAttribute_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", referencedColumnName = "PRODUCTTHEMEID", nullable = false, insertable = false, updatable = false)
    private Producttheme ProductthemeAttribute.productthemeProductthemeid;
    
    @ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute ProductthemeAttribute.attributesAttributeid;
    
    public Producttheme ProductthemeAttribute.getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }
    
    public void ProductthemeAttribute.setProductthemeProductthemeid(Producttheme productthemeProductthemeid) {
        this.productthemeProductthemeid = productthemeProductthemeid;
    }
    
    public Attribute ProductthemeAttribute.getAttributesAttributeid() {
        return attributesAttributeid;
    }
    
    public void ProductthemeAttribute.setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }
    
}
