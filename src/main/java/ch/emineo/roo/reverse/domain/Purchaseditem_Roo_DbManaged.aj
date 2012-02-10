// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Product;
import ch.emineo.roo.reverse.domain.Producttheme;
import ch.emineo.roo.reverse.domain.Productvariant;
import ch.emineo.roo.reverse.domain.Promotion;
import ch.emineo.roo.reverse.domain.Purchaseditem;
import ch.emineo.roo.reverse.domain.User;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect Purchaseditem_Roo_DbManaged {
    
    @ManyToMany(mappedBy = "purchaseditems")
    private Set<User> Purchaseditem.users;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTTHEME_PRODUCTTHEMEID", referencedColumnName = "PRODUCTTHEMEID")
    private Producttheme Purchaseditem.productthemeProductthemeid;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTVARIANT_PRODUCTVARIANTID", referencedColumnName = "PRODUCTVARIANTID")
    private Productvariant Purchaseditem.productvariantProductvariantid;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT_PRODUCTID", referencedColumnName = "PRODUCTID")
    private Product Purchaseditem.productProductid;
    
    @ManyToOne
    @JoinColumn(name = "PROMOTIONREFERENCE_PROMOTIONID", referencedColumnName = "PROMOTIONID")
    private Promotion Purchaseditem.promotionreferencePromotionid;
    
    @Column(name = "ACQUISITIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date Purchaseditem.acquisitiondate;
    
    @Column(name = "ONLINE")
    @NotNull
    private boolean Purchaseditem.online;
    
    @Column(name = "PROMOTION")
    @NotNull
    private boolean Purchaseditem.promotion;
    
    @Column(name = "PUBLIC")
    @NotNull
    private boolean Purchaseditem.public1;
    
    @Column(name = "REMINDERSENT")
    @NotNull
    private boolean Purchaseditem.remindersent;
    
    @Column(name = "TYPE", length = 255)
    private String Purchaseditem.type;
    
    public Set<User> Purchaseditem.getUsers() {
        return users;
    }
    
    public void Purchaseditem.setUsers(Set<User> users) {
        this.users = users;
    }
    
    public Producttheme Purchaseditem.getProductthemeProductthemeid() {
        return productthemeProductthemeid;
    }
    
    public void Purchaseditem.setProductthemeProductthemeid(Producttheme productthemeProductthemeid) {
        this.productthemeProductthemeid = productthemeProductthemeid;
    }
    
    public Productvariant Purchaseditem.getProductvariantProductvariantid() {
        return productvariantProductvariantid;
    }
    
    public void Purchaseditem.setProductvariantProductvariantid(Productvariant productvariantProductvariantid) {
        this.productvariantProductvariantid = productvariantProductvariantid;
    }
    
    public Product Purchaseditem.getProductProductid() {
        return productProductid;
    }
    
    public void Purchaseditem.setProductProductid(Product productProductid) {
        this.productProductid = productProductid;
    }
    
    public Promotion Purchaseditem.getPromotionreferencePromotionid() {
        return promotionreferencePromotionid;
    }
    
    public void Purchaseditem.setPromotionreferencePromotionid(Promotion promotionreferencePromotionid) {
        this.promotionreferencePromotionid = promotionreferencePromotionid;
    }
    
    public Date Purchaseditem.getAcquisitiondate() {
        return acquisitiondate;
    }
    
    public void Purchaseditem.setAcquisitiondate(Date acquisitiondate) {
        this.acquisitiondate = acquisitiondate;
    }
    
    public boolean Purchaseditem.isOnline() {
        return online;
    }
    
    public void Purchaseditem.setOnline(boolean online) {
        this.online = online;
    }
    
    public boolean Purchaseditem.isPromotion() {
        return promotion;
    }
    
    public void Purchaseditem.setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
    
    public boolean Purchaseditem.isPublic1() {
        return public1;
    }
    
    public void Purchaseditem.setPublic1(boolean public1) {
        this.public1 = public1;
    }
    
    public boolean Purchaseditem.isRemindersent() {
        return remindersent;
    }
    
    public void Purchaseditem.setRemindersent(boolean remindersent) {
        this.remindersent = remindersent;
    }
    
    public String Purchaseditem.getType() {
        return type;
    }
    
    public void Purchaseditem.setType(String type) {
        this.type = type;
    }
    
}
