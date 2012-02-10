// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Productcategory;
import ch.emineo.roo.reverse.domain.ProductcategoryAttribute;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect ProductcategoryAttribute_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID", referencedColumnName = "PRODUCTCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productcategory ProductcategoryAttribute.productcategoryProductcategoryid;
    
    @ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute ProductcategoryAttribute.attributesAttributeid;
    
    public Productcategory ProductcategoryAttribute.getProductcategoryProductcategoryid() {
        return productcategoryProductcategoryid;
    }
    
    public void ProductcategoryAttribute.setProductcategoryProductcategoryid(Productcategory productcategoryProductcategoryid) {
        this.productcategoryProductcategoryid = productcategoryProductcategoryid;
    }
    
    public Attribute ProductcategoryAttribute.getAttributesAttributeid() {
        return attributesAttributeid;
    }
    
    public void ProductcategoryAttribute.setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }
    
}
