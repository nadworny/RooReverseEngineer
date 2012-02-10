// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Product;
import ch.emineo.roo.reverse.domain.ProductAttribute;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect ProductAttribute_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute ProductAttribute.attributesAttributeid;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT_PRODUCTID", referencedColumnName = "PRODUCTID", nullable = false, insertable = false, updatable = false)
    private Product ProductAttribute.productProductid;
    
    public Attribute ProductAttribute.getAttributesAttributeid() {
        return attributesAttributeid;
    }
    
    public void ProductAttribute.setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }
    
    public Product ProductAttribute.getProductProductid() {
        return productProductid;
    }
    
    public void ProductAttribute.setProductProductid(Product productProductid) {
        this.productProductid = productProductid;
    }
    
}
