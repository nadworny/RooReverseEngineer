// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.ProductbuildProductbuildelementPK;
import javax.persistence.Column;
import javax.persistence.Embeddable;

privileged aspect ProductbuildProductbuildelementPK_Roo_Identifier {
    
    declare @type: ProductbuildProductbuildelementPK: @Embeddable;
    
    @Column(name = "PRODUCTBUILD_PRODUCTBUILDID", nullable = false)
    private Integer ProductbuildProductbuildelementPK.productbuildProductbuildid;
    
    @Column(name = "IDX", nullable = false)
    private Integer ProductbuildProductbuildelementPK.idx;
    
    public ProductbuildProductbuildelementPK.new(Integer productbuildProductbuildid, Integer idx) {
        super();
        this.productbuildProductbuildid = productbuildProductbuildid;
        this.idx = idx;
    }

    private ProductbuildProductbuildelementPK.new() {
        super();
    }

    public Integer ProductbuildProductbuildelementPK.getProductbuildProductbuildid() {
        return productbuildProductbuildid;
    }
    
    public Integer ProductbuildProductbuildelementPK.getIdx() {
        return idx;
    }
    
}