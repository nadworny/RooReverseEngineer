// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductthemesubcategoryAttributePK;
import javax.persistence.Column;
import javax.persistence.Embeddable;

privileged aspect ProductthemesubcategoryAttributePK_Roo_Identifier {
    
    declare @type: ProductthemesubcategoryAttributePK: @Embeddable;
    
    @Column(name = "PRODUCTTHEMESUBCATEGORY_PRODUCTTHEMESUBCATEGORYID", nullable = false)
    private Integer ProductthemesubcategoryAttributePK.productthemesubcategoryProductthemesubcategoryid;
    
    @Column(name = "IDX", nullable = false)
    private Integer ProductthemesubcategoryAttributePK.idx;
    
    public ProductthemesubcategoryAttributePK.new(Integer productthemesubcategoryProductthemesubcategoryid, Integer idx) {
        super();
        this.productthemesubcategoryProductthemesubcategoryid = productthemesubcategoryProductthemesubcategoryid;
        this.idx = idx;
    }

    private ProductthemesubcategoryAttributePK.new() {
        super();
    }

    public Integer ProductthemesubcategoryAttributePK.getProductthemesubcategoryProductthemesubcategoryid() {
        return productthemesubcategoryProductthemesubcategoryid;
    }
    
    public Integer ProductthemesubcategoryAttributePK.getIdx() {
        return idx;
    }
    
}
