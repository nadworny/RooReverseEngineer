// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductsubcategoryAttributePK;
import javax.persistence.Column;
import javax.persistence.Embeddable;

privileged aspect ProductsubcategoryAttributePK_Roo_Identifier {
    
    declare @type: ProductsubcategoryAttributePK: @Embeddable;
    
    @Column(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID", nullable = false)
    private Integer ProductsubcategoryAttributePK.productsubcategoryProductsubcategoryid;
    
    @Column(name = "IDX", nullable = false)
    private Integer ProductsubcategoryAttributePK.idx;
    
    public ProductsubcategoryAttributePK.new(Integer productsubcategoryProductsubcategoryid, Integer idx) {
        super();
        this.productsubcategoryProductsubcategoryid = productsubcategoryProductsubcategoryid;
        this.idx = idx;
    }

    private ProductsubcategoryAttributePK.new() {
        super();
    }

    public Integer ProductsubcategoryAttributePK.getProductsubcategoryProductsubcategoryid() {
        return productsubcategoryProductsubcategoryid;
    }
    
    public Integer ProductsubcategoryAttributePK.getIdx() {
        return idx;
    }
    
}
