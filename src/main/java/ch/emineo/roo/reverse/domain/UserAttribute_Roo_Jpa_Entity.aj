// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.UserAttribute;
import ch.emineo.roo.reverse.domain.UserAttributePK;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

privileged aspect UserAttribute_Roo_Jpa_Entity {
    
    declare @type: UserAttribute: @Entity;
    
    declare @type: UserAttribute: @Table(name = "user_attribute");
    
    @EmbeddedId
    private UserAttributePK UserAttribute.id;
    
    public UserAttributePK UserAttribute.getId() {
        return this.id;
    }
    
    public void UserAttribute.setId(UserAttributePK id) {
        this.id = id;
    }
    
}