// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Message;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect Message_Roo_Jpa_Entity {
    
    declare @type: Message: @Entity;
    
    declare @type: Message: @Table(name = "message");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MESSAGEID")
    private Integer Message.messageid;
    
    public Integer Message.getMessageid() {
        return this.messageid;
    }
    
    public void Message.setMessageid(Integer id) {
        this.messageid = id;
    }
    
}