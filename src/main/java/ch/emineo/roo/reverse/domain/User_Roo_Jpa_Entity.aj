// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect User_Roo_Jpa_Entity {
    
    declare @type: User: @Entity;
    
    declare @type: User: @Table(name = "user");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID")
    private Integer User.userid;
    
    public Integer User.getUserid() {
        return this.userid;
    }
    
    public void User.setUserid(Integer id) {
        this.userid = id;
    }
    
}
