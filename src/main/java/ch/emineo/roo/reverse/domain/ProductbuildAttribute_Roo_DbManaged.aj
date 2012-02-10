// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Attribute;
import ch.emineo.roo.reverse.domain.Productbuild;
import ch.emineo.roo.reverse.domain.ProductbuildAttribute;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect ProductbuildAttribute_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTBUILD_PRODUCTBUILDID", referencedColumnName = "PRODUCTBUILDID", nullable = false, insertable = false, updatable = false)
    private Productbuild ProductbuildAttribute.productbuildProductbuildid;
    
    @ManyToOne
    @JoinColumn(name = "ATTRIBUTES_ATTRIBUTEID", referencedColumnName = "ATTRIBUTEID", nullable = false)
    private Attribute ProductbuildAttribute.attributesAttributeid;
    
    public Productbuild ProductbuildAttribute.getProductbuildProductbuildid() {
        return productbuildProductbuildid;
    }
    
    public void ProductbuildAttribute.setProductbuildProductbuildid(Productbuild productbuildProductbuildid) {
        this.productbuildProductbuildid = productbuildProductbuildid;
    }
    
    public Attribute ProductbuildAttribute.getAttributesAttributeid() {
        return attributesAttributeid;
    }
    
    public void ProductbuildAttribute.setAttributesAttributeid(Attribute attributesAttributeid) {
        this.attributesAttributeid = attributesAttributeid;
    }
    
}