// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductbuildelementContentPK;
import javax.persistence.Column;
import javax.persistence.Embeddable;

privileged aspect ProductbuildelementContentPK_Roo_Identifier {
    
    declare @type: ProductbuildelementContentPK: @Embeddable;
    
    @Column(name = "PRODUCTBUILDELEMENT_PRODUCTBUILDELEMENTID", nullable = false)
    private Integer ProductbuildelementContentPK.productbuildelementProductbuildelementid;
    
    @Column(name = "IDX", nullable = false)
    private Integer ProductbuildelementContentPK.idx;
    
    public ProductbuildelementContentPK.new(Integer productbuildelementProductbuildelementid, Integer idx) {
        super();
        this.productbuildelementProductbuildelementid = productbuildelementProductbuildelementid;
        this.idx = idx;
    }

    private ProductbuildelementContentPK.new() {
        super();
    }

    public Integer ProductbuildelementContentPK.getProductbuildelementProductbuildelementid() {
        return productbuildelementProductbuildelementid;
    }
    
    public Integer ProductbuildelementContentPK.getIdx() {
        return idx;
    }
    
}
