// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productcategory;
import ch.emineo.roo.reverse.domain.ProductcategoryProductsubcategory;
import ch.emineo.roo.reverse.domain.Productsubcategory;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

privileged aspect ProductcategoryProductsubcategory_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTCATEGORY_PRODUCTCATEGORYID", referencedColumnName = "PRODUCTCATEGORYID", nullable = false, insertable = false, updatable = false)
    private Productcategory ProductcategoryProductsubcategory.productcategoryProductcategoryid;
    
    @ManyToOne
    @JoinColumn(name = "SUBCATEGORIES_PRODUCTSUBCATEGORYID", referencedColumnName = "PRODUCTSUBCATEGORYID", nullable = false)
    private Productsubcategory ProductcategoryProductsubcategory.subcategoriesProductsubcategoryid;
    
    public Productcategory ProductcategoryProductsubcategory.getProductcategoryProductcategoryid() {
        return productcategoryProductcategoryid;
    }
    
    public void ProductcategoryProductsubcategory.setProductcategoryProductcategoryid(Productcategory productcategoryProductcategoryid) {
        this.productcategoryProductcategoryid = productcategoryProductcategoryid;
    }
    
    public Productsubcategory ProductcategoryProductsubcategory.getSubcategoriesProductsubcategoryid() {
        return subcategoriesProductsubcategoryid;
    }
    
    public void ProductcategoryProductsubcategory.setSubcategoriesProductsubcategoryid(Productsubcategory subcategoriesProductsubcategoryid) {
        this.subcategoriesProductsubcategoryid = subcategoriesProductsubcategoryid;
    }
    
}
