// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Productthemecategory;
import ch.emineo.roo.reverse.domain.ProductthemecategoryAttribute;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect ProductthemecategoryAttribute_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute ProductthemecategoryAttribute.attributesAttributeid;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTTHEMECATEGORY_PRODUCTTHEMECATEGORYID", referencedColumnName = "PRODUCTTHEMECATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productthemecategory ProductthemecategoryAttribute.productthemecategoryProductthemecategoryid;
    
    public Attribute ProductthemecategoryAttribute.getAttributesAttributeid() {
        return attributesAttributeid;
    }
    
    public void ProductthemecategoryAttribute.setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }
    
    public Productthemecategory ProductthemecategoryAttribute.getProductthemecategoryProductthemecategoryid() {
        return productthemecategoryProductthemecategoryid;
    }
    
    public void ProductthemecategoryAttribute.setProductthemecategoryProductthemecategoryid(Productthemecategory productthemecategoryProductthemecategoryid) {
        this.productthemecategoryProductthemecategoryid = productthemecategoryProductthemecategoryid;
    }
    
}
