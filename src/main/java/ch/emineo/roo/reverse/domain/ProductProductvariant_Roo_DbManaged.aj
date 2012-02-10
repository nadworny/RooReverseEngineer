// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Product;
import ch.emineo.roo.reverse.domain.ProductProductvariant;
import ch.emineo.roo.reverse.domain.Productvariant;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect ProductProductvariant_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT_PRODUCTID", referencedColumnName = "PRODUCTID", nullable = false, insertable = false, updatable = false)
    private Product ProductProductvariant.productProductid;
    
    @ManyToOne
    @JoinColumn(name = "VARIANTS_PRODUCTVARIANTID", referencedColumnName = "PRODUCTVARIANTID", nullable = false)
    private Productvariant ProductProductvariant.variantsProductvariantid;
    
    public Product ProductProductvariant.getProductProductid() {
        return productProductid;
    }
    
    public void ProductProductvariant.setProductProductid(Product productProductid) {
        this.productProductid = productProductid;
    }
    
    public Productvariant ProductProductvariant.getVariantsProductvariantid() {
        return variantsProductvariantid;
    }
    
    public void ProductProductvariant.setVariantsProductvariantid(Productvariant variantsProductvariantid) {
        this.variantsProductvariantid = variantsProductvariantid;
    }
    
}
