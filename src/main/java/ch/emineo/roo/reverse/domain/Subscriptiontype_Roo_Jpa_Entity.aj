// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Subscriptiontype;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Subscriptiontype_Roo_Jpa_Entity {
    
    declare @type: Subscriptiontype: @Entity;
    
    declare @type: Subscriptiontype: @Table(name = "subscriptiontype");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MONTHS")
    private Integer Subscriptiontype.months;
    
    public Integer Subscriptiontype.getMonths() {
        return this.months;
    }
    
    public void Subscriptiontype.setMonths(Integer id) {
        this.months = id;
    }
    
}