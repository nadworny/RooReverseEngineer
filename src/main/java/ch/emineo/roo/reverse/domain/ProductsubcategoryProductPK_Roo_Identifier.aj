// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductsubcategoryProductPK;
import javax.persistence.Column;
import javax.persistence.Embeddable;

privileged aspect ProductsubcategoryProductPK_Roo_Identifier {
    
    declare @type: ProductsubcategoryProductPK: @Embeddable;
    
    @Column(name = "PRODUCTSUBCATEGORY_PRODUCTSUBCATEGORYID", nullable = false)
    private Integer ProductsubcategoryProductPK.productsubcategoryProductsubcategoryid;
    
    @Column(name = "IDX", nullable = false)
    private Integer ProductsubcategoryProductPK.idx;
    
    public ProductsubcategoryProductPK.new(Integer productsubcategoryProductsubcategoryid, Integer idx) {
        super();
        this.productsubcategoryProductsubcategoryid = productsubcategoryProductsubcategoryid;
        this.idx = idx;
    }

    private ProductsubcategoryProductPK.new() {
        super();
    }

    public Integer ProductsubcategoryProductPK.getProductsubcategoryProductsubcategoryid() {
        return productsubcategoryProductsubcategoryid;
    }
    
    public Integer ProductsubcategoryProductPK.getIdx() {
        return idx;
    }
    
}
