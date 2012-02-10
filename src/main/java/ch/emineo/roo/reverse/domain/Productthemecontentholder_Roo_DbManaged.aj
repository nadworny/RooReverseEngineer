// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Productbuild;
import ch.emineo.roo.reverse.domain.Productthemecontentholder;
import ch.emineo.roo.reverse.domain.ProductthemecontentholderAttribute;
import ch.emineo.roo.reverse.domain.ProductthemesubcategoryProductthemecontentholder;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

privileged aspect Productthemecontentholder_Roo_DbManaged {
    
    @OneToMany(mappedBy = "productthemecontentholderProductthemecontentholderid")
    private Set<ProductthemecontentholderAttribute> Productthemecontentholder.productthemecontentholderAttributes;
    
    @OneToMany(mappedBy = "productthemecontentholdersProductthemecontentholderid")
    private Set<ProductthemesubcategoryProductthemecontentholder> Productthemecontentholder.productthemesubcategoryProductthemecontentholders;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTBUILD_FK", referencedColumnName = "PRODUCTBUILDID")
    private Productbuild Productthemecontentholder.productbuildFk;
    
    @Column(name = "ONLINE")
    @NotNull
    private boolean Productthemecontentholder.online;
    
    @Column(name = "PUBLIC")
    @NotNull
    private boolean Productthemecontentholder.public1;
    
    public Set<ProductthemecontentholderAttribute> Productthemecontentholder.getProductthemecontentholderAttributes() {
        return productthemecontentholderAttributes;
    }
    
    public void Productthemecontentholder.setProductthemecontentholderAttributes(Set<ProductthemecontentholderAttribute> productthemecontentholderAttributes) {
        this.productthemecontentholderAttributes = productthemecontentholderAttributes;
    }
    
    public Set<ProductthemesubcategoryProductthemecontentholder> Productthemecontentholder.getProductthemesubcategoryProductthemecontentholders() {
        return productthemesubcategoryProductthemecontentholders;
    }
    
    public void Productthemecontentholder.setProductthemesubcategoryProductthemecontentholders(Set<ProductthemesubcategoryProductthemecontentholder> productthemesubcategoryProductthemecontentholders) {
        this.productthemesubcategoryProductthemecontentholders = productthemesubcategoryProductthemecontentholders;
    }
    
    public Productbuild Productthemecontentholder.getProductbuildFk() {
        return productbuildFk;
    }
    
    public void Productthemecontentholder.setProductbuildFk(Productbuild productbuildFk) {
        this.productbuildFk = productbuildFk;
    }
    
    public boolean Productthemecontentholder.isOnline() {
        return online;
    }
    
    public void Productthemecontentholder.setOnline(boolean online) {
        this.online = online;
    }
    
    public boolean Productthemecontentholder.isPublic1() {
        return public1;
    }
    
    public void Productthemecontentholder.setPublic1(boolean public1) {
        this.public1 = public1;
    }
    
}